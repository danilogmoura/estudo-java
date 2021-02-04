package com.dmg.aifood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmg.aifood.domain.model.FormaPagamento;
import com.dmg.aifood.domain.repository.FormaPagamentoRepository;
import com.dmg.aifood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoControle {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;

	@GetMapping
	public List<FormaPagamento> listar() {
		return formaPagamentoRepository.findAll();
	}

	@GetMapping("/{pagamentoId}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long pagamentoId) {
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(pagamentoId);

		if (formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}
		return ResponseEntity.notFound().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return cadastroFormaPagamento.salvar(formaPagamento);
	}

	@PutMapping("/{pagamentoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long pagamentoId, @RequestBody FormaPagamento formaPagamento) {
		Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(pagamentoId);

		if (formaPagamentoAtual.isPresent()) {
			BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id");

			FormaPagamento formaPagamentoSalvo = cadastroFormaPagamento.salvar(formaPagamentoAtual.get());
			return ResponseEntity.ok(formaPagamentoSalvo);

		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{pagamentoId}")
	public ResponseEntity<?> remover(@PathVariable Long pagamentoId) {
		try {
			cadastroFormaPagamento.remover(pagamentoId);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}

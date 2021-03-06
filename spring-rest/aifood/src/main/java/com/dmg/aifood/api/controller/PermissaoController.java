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

import com.dmg.aifood.domain.model.Permissao;
import com.dmg.aifood.domain.repository.PermissaoRepository;
import com.dmg.aifood.domain.service.CadastroPermissaoService;

@RestController
@RequestMapping("permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Autowired
	private CadastroPermissaoService cadastroPermissao;

	@GetMapping
	public List<Permissao> listar() {
		return permissaoRepository.findAll();
	}

	@GetMapping("/{permissaoId}")
	public ResponseEntity<?> buscar(@PathVariable Long permissaoId) {
		Optional<Permissao> permissao = permissaoRepository.findById(permissaoId);

		if (permissao.isPresent()) {
			return ResponseEntity.ok(permissao.get());
		}

		return ResponseEntity.notFound().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Permissao adicionar(@RequestBody Permissao permissao) {
		return cadastroPermissao.salvar(permissao);
	}

	@PutMapping("/{permissaoId}")
	public ResponseEntity<?> atualizar(@PathVariable Long permissaoId, @RequestBody Permissao permissao) {
		Optional<Permissao> permissaoAtual = permissaoRepository.findById(permissaoId);

		if (permissaoAtual.isPresent()) {
			BeanUtils.copyProperties(permissao, permissaoAtual.get(), "id");

			Permissao permissaoSalva = cadastroPermissao.salvar(permissaoAtual.get());
			return ResponseEntity.ok(permissaoSalva);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{permissaoId}")
	public ResponseEntity<?> remover(@PathVariable Long permissaoId) {
		try {
			cadastroPermissao.remover(permissaoId);

			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}

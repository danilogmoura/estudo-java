package com.dmg.aifood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmg.aifood.domain.model.FormaPagamento;
import com.dmg.aifood.domain.repository.FormaPagamentoRepository;

@Service
public class CadastroFormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}

	@Transactional
	public void remover(Long id) {
		formaPagamentoRepository.deleteById(id);
	}
}

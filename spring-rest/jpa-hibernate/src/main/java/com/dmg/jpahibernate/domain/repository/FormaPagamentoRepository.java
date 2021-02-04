package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	@Transactional
	FormaPagamento adicionar(FormaPagamento formaPagamento);

	List<FormaPagamento> todas();

	FormaPagamento porId(Long id);

	@Transactional
	void remove(FormaPagamento formaPagamento);
}

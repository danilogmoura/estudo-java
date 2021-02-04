package com.dmg.jpahibernate.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.dmg.jpahibernate.domain.model.FormaPagamento;
import com.dmg.jpahibernate.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}

	@Override
	public List<FormaPagamento> todas() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Override
	public void remove(FormaPagamento formaPagamento) {
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}

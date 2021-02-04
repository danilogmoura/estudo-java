package com.dmg.jpahibernate.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.dmg.jpahibernate.domain.model.Estado;
import com.dmg.jpahibernate.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	public List<Estado> todos() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Override
	public void remover(Estado estado) {
		estado = porId(estado.getId());
		manager.remove(estado);
	}

}

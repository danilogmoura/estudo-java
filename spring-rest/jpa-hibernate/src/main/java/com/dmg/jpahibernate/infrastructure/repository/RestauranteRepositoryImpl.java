package com.dmg.jpahibernate.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}

	@Override
	public List<Restaurante> todos() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante porId(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Override
	public void remover(Restaurante restaurante) {
		restaurante = porId(restaurante.getId());
		manager.remove(restaurante);
	}
}

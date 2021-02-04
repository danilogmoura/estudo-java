package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.Restaurante;

public interface RestauranteRepository {

	@Transactional
	Restaurante adicionar(Restaurante restaurante);

	List<Restaurante> todos();

	Restaurante porId(Long id);

	@Transactional
	void remover(Restaurante restaurante);
}

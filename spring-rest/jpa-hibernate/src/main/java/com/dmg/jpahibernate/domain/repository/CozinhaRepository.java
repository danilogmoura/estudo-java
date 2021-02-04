package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.Cozinha;

public interface CozinhaRepository {

	@Transactional
	Cozinha adicionar(Cozinha cozinha);

	List<Cozinha> todas();

	Cozinha porId(Long id);

	@Transactional
	void remover(Cozinha cozinha);

}

package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.Cidade;

public interface CidadeRepository {

	@Transactional
	Cidade adicionar(Cidade cidade);

	List<Cidade> todas();

	Cidade porId(Long id);

	@Transactional
	void remove(Cidade cidades);

}

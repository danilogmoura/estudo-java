package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.Permissao;

public interface PermissaoRepository {

	@Transactional
	Permissao adicionar(Permissao permissao);

	List<Permissao> todas();

	Permissao porId(Long id);

	@Transactional
	void remove(Permissao permissao);
}

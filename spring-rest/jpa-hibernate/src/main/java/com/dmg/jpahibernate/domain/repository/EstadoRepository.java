package com.dmg.jpahibernate.domain.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dmg.jpahibernate.domain.model.Estado;

public interface EstadoRepository {

	@Transactional
	Estado adicionar(Estado estado);

	List<Estado> todos();

	Estado porId(Long id);

	@Transactional
	void remover(Estado estado);

}

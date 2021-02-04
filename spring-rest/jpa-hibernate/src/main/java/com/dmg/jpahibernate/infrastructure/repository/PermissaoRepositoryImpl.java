package com.dmg.jpahibernate.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.dmg.jpahibernate.domain.model.Permissao;
import com.dmg.jpahibernate.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Permissao adicionar(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	public List<Permissao> todas() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao porId(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Override
	public void remove(Permissao permissao) {
		permissao = porId(permissao.getId());
		manager.remove(permissao);
	}

}

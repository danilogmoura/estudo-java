package com.dmg.jpahibernate.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.dmg.jpahibernate.domain.model.Cidade;
import com.dmg.jpahibernate.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	public List<Cidade> todas() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	public void remove(Cidade cidades) {
		cidades = porId(cidades.getId());
		manager.remove(cidades);
	}

}

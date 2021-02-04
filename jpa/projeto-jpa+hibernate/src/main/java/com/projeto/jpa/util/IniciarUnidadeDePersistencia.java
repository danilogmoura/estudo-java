package com.projeto.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.jpa.model.Produto;

public class IniciarUnidadeDePersistencia {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjetoJPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Produto produto = entityManager.find(Produto.class, 1L);

		System.out.println(produto.getNome());

		entityManager.close();
		entityManagerFactory.close();
	}

}

package com.estudo.jpa.iniciando;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Acessorio;

public class AcessoriosTeste extends EntityManagerTest {

	@Test
	public void buscarTodos() {
		List<Acessorio> acessorios = entityManager.createQuery("SELECT a FROM Acessorio a", Acessorio.class).getResultList();

		assertEquals(5, acessorios.size());
	}
}

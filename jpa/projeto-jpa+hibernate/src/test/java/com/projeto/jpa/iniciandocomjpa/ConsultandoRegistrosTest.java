package com.projeto.jpa.iniciandocomjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.projeto.jpa.EntityManagerTest;
import com.projeto.jpa.model.Produto;

public class ConsultandoRegistrosTest extends EntityManagerTest {

	@Test
	public void busarPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1L);

		assertNotNull(produto);
		assertEquals("Kindle", produto.getNome());
	}

	@Test
	public void atualizarReferencia() {
		Produto produto = entityManager.find(Produto.class, 1L);
		produto.setNome("Microfone Samson");

		entityManager.refresh(produto);
		assertEquals("Kinle", produto.getNome());
	}
}

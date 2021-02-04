package com.estudo.jpa.iniciando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Fabricante;

public class FabricanteTeste extends EntityManagerTest {

	@Test
	public void inserir() {
		long individualId = 4;

		Fabricante fabricante = new Fabricante();
		fabricante.setNome("Honda");

		entityManager.getTransaction().begin();
		entityManager.persist(fabricante);
		entityManager.getTransaction().commit();

		entityManager.clear();

		assertEquals(individualId, fabricante.getId());
	}

	@Test
	public void pesquisar() {
		Fabricante fabricante = entityManager.find(Fabricante.class, 2L);

		assertNotNull(fabricante);
		assertEquals("Toyota", fabricante.getNome());
	}

	@Test
	public void pesquisarTodos() {
		List<Fabricante> fabricantes = entityManager.createQuery("SELECT f FROM Fabricante f", Fabricante.class).getResultList();

		assertEquals(3, fabricantes.size());
	}

	@Test
	public void exluir() {
		long fabricanteId = 2;

		Fabricante fabricante = entityManager.find(Fabricante.class, fabricanteId);

		entityManager.getTransaction().begin();
		entityManager.remove(fabricante);
		entityManager.getTransaction().commit();

		Fabricante fabricanteVerificado = entityManager.find(Fabricante.class, fabricanteId);

		assertNull(fabricanteVerificado);
	}

	@Test
	public void atualizarObjetoGerenciado() {
		long fabricanteId = 2;
		String novoNome = "General Motors";

		Fabricante fabricante = entityManager.find(Fabricante.class, fabricanteId);

		entityManager.getTransaction().begin();
		fabricante.setNome(novoNome);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Fabricante fabricanteVerificado = entityManager.find(Fabricante.class, fabricanteId);

		assertNotNull(fabricanteVerificado);
		assertEquals(novoNome, fabricanteVerificado.getNome());

	}

	@Test
	public void atualizarObjeto() {
		long fabricanteId = 2;
		String fabricanteNome = "General Motors";

		Fabricante fabricante = new Fabricante();

		fabricante.setId(fabricanteId);
		fabricante.setNome(fabricanteNome);

		entityManager.getTransaction().begin();
		entityManager.merge(fabricante);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Fabricante fabricanteVerificado = entityManager.find(Fabricante.class, fabricanteId);

		assertNotNull(fabricanteVerificado);
		assertEquals(fabricanteId, fabricanteVerificado.getId());
		assertEquals(fabricanteNome, fabricanteVerificado.getNome());
	}
}

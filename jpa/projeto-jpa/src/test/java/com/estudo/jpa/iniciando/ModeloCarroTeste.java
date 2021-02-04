package com.estudo.jpa.iniciando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Categoria;
import com.estudo.jpa.model.Fabricante;
import com.estudo.jpa.model.ModeloCarro;

public class ModeloCarroTeste extends EntityManagerTest {

	@Test
	public void buscar() {
		long modeloCarroId = 2;
		String modeloDescricao = "S10 Cabine Dupla";

		ModeloCarro modeloCarro = entityManager.find(ModeloCarro.class, modeloCarroId);

		assertNotNull(modeloCarro);
		assertEquals(modeloDescricao, modeloCarro.getDescricao());
	}

	@Test
	public void inserir() {
		long fabricanteId = 2;

		long modeloCarroId = 4;
		String modeloDescricao = "PRIUS";

		Fabricante fabricante = new Fabricante();
		fabricante.setId(fabricanteId);

		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setDescricao(modeloDescricao);
		modeloCarro.setCategoria(Categoria.MINIVAN);

		modeloCarro.setFabricante(fabricante);

		entityManager.getTransaction().begin();
		entityManager.persist(modeloCarro);
		entityManager.getTransaction().commit();
		entityManager.clear();

		ModeloCarro modeloCarroValidacao = entityManager.find(ModeloCarro.class, modeloCarroId);

		assertNotNull(modeloCarroValidacao);
		assertEquals(modeloDescricao, modeloCarro.getDescricao());
		assertEquals(modeloCarro.getFabricante().getId(), fabricanteId);
		assertEquals(Categoria.MINIVAN, modeloCarroValidacao.getCategoria());
	}
}

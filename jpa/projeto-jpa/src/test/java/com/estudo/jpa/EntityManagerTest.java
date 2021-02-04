package com.estudo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerTest {

	protected static EntityManagerFactory entityManagerFactory;

	protected EntityManager entityManager;

	private static FluentConfiguration configuration = Flyway.configure()
			.dataSource("jdbc:postgresql://localhost:5432/projeto_jpa", "postgres", "postgres");

	@BeforeAll
	public static void setUpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("ProjetoJPA-PU");
	}

	@AfterAll
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}

	@BeforeEach
	public void setUp() {
		new Flyway(configuration).migrate();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@AfterEach
	public void tearDown() {
		entityManager.close();
	}
}

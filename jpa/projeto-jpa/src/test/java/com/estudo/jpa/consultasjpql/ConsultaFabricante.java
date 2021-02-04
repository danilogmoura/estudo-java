package com.estudo.jpa.consultasjpql;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Fabricante;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaFabricante extends EntityManagerTest {

    @Test
    public void buscaTodos() {
        List<Fabricante> fabricantes = entityManager
                .createQuery("SELECT f FROM Fabricante f", Fabricante.class)
                .getResultList();

        assertEquals(3, fabricantes.size());

        fabricantes.forEach(System.out::println);
    }

    @Test
    public void buscarNomes() {
        List<String> nomesFabricantes = entityManager
                .createQuery("SELECT f.nome FROM Fabricante f", String.class)
                .getResultList();

        assertEquals(3, nomesFabricantes.size());
        nomesFabricantes.forEach(System.out::println);
    }

    @Test
    public void consultaPeloModeloCarro() {
        List<String> nomesFabricantes = entityManager
                .createQuery("SELECT m.fabricante.nome FROM ModeloCarro m", String.class)
                .getResultList();

        assertEquals(3, nomesFabricantes.size());
        nomesFabricantes.forEach(System.out::println);
    }
}

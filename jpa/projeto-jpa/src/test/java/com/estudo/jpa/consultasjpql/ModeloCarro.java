package com.estudo.jpa.consultasjpql;

import com.estudo.jpa.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModeloCarro extends EntityManagerTest {

    @Test
    public void filtrandoPorFabricante() {
        List<String> modeloCarros = entityManager
                .createQuery("SELECT m.descricao FROM ModeloCarro m WHERE m.fabricante.nome = :fabricante", String.class)
                .setParameter("fabricante", "Chevrolet")
                .getResultList();

        assertEquals(2, modeloCarros.size());
        modeloCarros.forEach(System.out::println);
    }

    @Test
    public void usandoClauseIN() {
        List<String> nomeFabricantes = new ArrayList<>();
        nomeFabricantes.add("Chevrolet");
        nomeFabricantes.add("Mercedes-Benz");

        List<String> modelosCarros = entityManager
                .createQuery("SELECT m.descricao FROM ModeloCarro m WHERE m.fabricante.nome IN (:fabricantes)", String.class)
                .setParameter("fabricantes", nomeFabricantes)
                .getResultList();

        assertEquals(3, modelosCarros.size());
        modelosCarros.forEach(System.out::println);
    }

    @Test
    public void usandoClauseLIKE() {
        List<String> modelosCarros = entityManager
                .createQuery("SELECT m.descricao FROM ModeloCarro m WHERE m.fabricante.nome LIKE :fabricante", String.class)
                .setParameter("fabricante", "%des%")
                .getResultList();

        assertEquals(1, modelosCarros.size());
        modelosCarros.forEach(System.out::println);
    }
}

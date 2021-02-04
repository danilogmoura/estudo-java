package com.estudo.jpa.consultasjpql;

import com.estudo.jpa.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaAcessoriosPorModeloCarro extends EntityManagerTest {

    @Test
    public void porModeloCarro() {

        String jpql = "SELECT a.descricao " +
                "FROM Carro c JOIN c.acessorios a " +
                "WHERE c.modeloCarro.descricao = :modeloCarro";

        List<String> acessorios = entityManager
                .createQuery(jpql, String.class)
                .setParameter("modeloCarro", "Onix")
                .getResultList();

        assertEquals(3, acessorios.size());
        acessorios.forEach(System.out::println);
    }
}

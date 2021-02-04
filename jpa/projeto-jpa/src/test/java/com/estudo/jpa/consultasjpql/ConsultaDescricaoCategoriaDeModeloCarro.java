package com.estudo.jpa.consultasjpql;

import com.estudo.jpa.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConsultaDescricaoCategoriaDeModeloCarro extends EntityManagerTest {

    @Test
    public void descricaoCategoria() {
        String jpql = "SELECT m.descricao, m.categoria FROM ModeloCarro m";

        List<Object[]> resuList = entityManager
                .createQuery(jpql, Object[].class)
                .getResultList();

        resuList.forEach(obj -> System.out.printf("Descrição: %s. Categoria %s\n", obj[0], obj[1]));
    }
}

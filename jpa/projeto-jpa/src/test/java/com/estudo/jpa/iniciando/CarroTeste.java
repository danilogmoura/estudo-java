package com.estudo.jpa.iniciando;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Acessorio;
import com.estudo.jpa.model.Carro;
import com.estudo.jpa.model.ModeloCarro;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarroTeste extends EntityManagerTest {

    @Test
    public void inserir() {
        // Modelo do carro
        ModeloCarro modeloCarro = new ModeloCarro();
        modeloCarro.setId(2L);

        // Acessorios
        List<Acessorio> acessorios = new ArrayList<>();

        Acessorio protetorCarter = new Acessorio();
        protetorCarter.setId(3L);
        acessorios.add(protetorCarter);

        Acessorio engate = new Acessorio();
        engate.setId(4L);
        acessorios.add(engate);

        Acessorio arCondicionado = new Acessorio();
        arCondicionado.setId(5L);
        acessorios.add(arCondicionado);

        // Carro
        Carro carro = new Carro();
        carro.setPlaca("MDH - 29729");
        carro.setChassi("D83D92993232");
        carro.setCor("azul marinho");
        carro.setValorDiaria(new BigDecimal("5.98"));
        carro.setAcessorios(acessorios);
        carro.setModeloCarro(modeloCarro);

        entityManager.getTransaction().begin();
        entityManager.merge(carro);
        entityManager.getTransaction().commit();

        Carro carroValidacao = entityManager.find(Carro.class, 4L);

        assertNotNull(carroValidacao);
        assertEquals("MDH - 29729", carroValidacao.getPlaca());
        assertEquals(3, carroValidacao.getAcessorios().size());
        assertEquals("S10 Cabine Dupla", carroValidacao.getModeloCarro().getDescricao());
    }

    @Test
    public void buscar() {
        Carro carro = entityManager.find(Carro.class, 1L);

        assertNotNull(carro);
        assertEquals("AD73452CW", carro.getChassi());
    }

    @Test
    public void buscarTodosNamedQuery() {
        List<Carro> carros = entityManager
                .createNamedQuery("Carro.buscarTodos", Carro.class)
                .getResultList();

        assertEquals(3, carros.size());

        carros.forEach(System.out::println);
    }

    @Test
    public void buscarCarroComAcessorios() {
        long carroId = 1L;

        Carro carro = entityManager.createNamedQuery("Carro.buscarCarroComAcessorios", Carro.class)
                .setParameter("id", carroId)
                .getSingleResult();

        assertNotNull(carro.getAcessorios());
        assertEquals(3, carro.getAcessorios().size());
    }
}

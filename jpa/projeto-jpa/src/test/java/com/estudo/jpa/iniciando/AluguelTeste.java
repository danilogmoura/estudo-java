package com.estudo.jpa.iniciando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.estudo.jpa.model.Motorista;
import org.junit.jupiter.api.Test;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.model.Aluguel;
import com.estudo.jpa.model.ApoliceSeguro;
import com.estudo.jpa.model.Carro;

public class AluguelTeste extends EntityManagerTest {

    @Test
    public void buscar() {
        Aluguel aluguel = entityManager.find(Aluguel.class, 1L);

        assertNotNull(aluguel);
        assertEquals(new BigDecimal("45.30"), aluguel.getValorTotal());
        assertEquals("Danilo", aluguel.getMotorista().getNome());
        assertEquals("Mercedes-AMG GT 63 S 4MATIC+", aluguel.getCarro().getModeloCarro().getDescricao());
    }

    @Test
    public void cadastrar() {
        // Apolice Seguro
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setValorFranquia(new BigDecimal("2600.87"));
        apoliceSeguro.setProtecaoCausasNaturais(true);
        apoliceSeguro.setProtecaoRoubo(true);
        apoliceSeguro.setProtecaoTerceiro(true);

        // Carro
        Carro carro = new Carro();
        carro.setId(2L);

        Motorista motorista = new Motorista();
        motorista.setId(1L);

        // Aluguel
        Aluguel aluguel = new Aluguel();
        aluguel.setCarro(carro);
        aluguel.setMotorista(motorista);
        aluguel.setApoliceSeguro(apoliceSeguro);
        aluguel.setValorTotal(new BigDecimal("78.24"));
        aluguel.setDataEntrega(OffsetDateTime.parse("2020-11-18T10:00:00-03:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        aluguel.setDataDevolucao(OffsetDateTime.parse("2020-11-18T05:00:00-03:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        entityManager.getTransaction().begin();
        entityManager.persist(aluguel);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Aluguel aluguelAvaliacao = entityManager.find(Aluguel.class, 4L);
        assertNotNull(aluguelAvaliacao);
        assertEquals(new BigDecimal("78.24"), aluguelAvaliacao.getValorTotal());
    }
}

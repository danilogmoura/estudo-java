package com.estudo.jpa.consultasjpql;

import com.estudo.jpa.EntityManagerTest;
import com.estudo.jpa.dto.AluguelCarroInfo;
import com.estudo.jpa.model.Carro;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultasAgregadas extends EntityManagerTest {

    @Test
    public void agregadas() {
        String jpql = "" +
                "SELECT c, COUNT(a), MAX(a.valorTotal), AVG(a.valorTotal) " +
                "FROM Carro c JOIN c.alugueis a " +
                "GROUP BY c " +
                "HAVING COUNT(a) > 1";

        List<Object[]> resultList = entityManager
                .createQuery(jpql, Object[].class)
                .getResultList();

        assertEquals(1, resultList.size());

        resultList.forEach(obj -> System.out.printf("Modelo: %s\n" +
                        "Quantidade de alugueis: %s\n" +
                        "Valor máximo: %s\n" +
                        "Valor médio: %s%n\n",
                ((Carro) obj[0]).getModeloCarro().getDescricao(), obj[1], obj[2], obj[3]));

    }

    @Test
    public void agregadasDTO() {
        String jpql = "" +
                "SELECT NEW com.estudo.jpa.dto.AluguelCarroInfo(c, COUNT(a), MAX(a.valorTotal), AVG(a.valorTotal)) " +
                "FROM Carro c JOIN c.alugueis a " +
                "GROUP BY c " +
                "HAVING COUNT(a) > 1";

        List<AluguelCarroInfo> resultList = entityManager
                .createQuery(jpql, AluguelCarroInfo.class)
                .getResultList();

        assertEquals(1, resultList.size());

        resultList.forEach(carroInfo -> System.out.printf("Modelo: %s\n" +
                        "Quantidade de alugueis: %s\n" +
                        "Valor máximo: %s\n" +
                        "Valor médio: %s%n\n",
                carroInfo.getCarro().getModeloCarro().getDescricao(),
                carroInfo.getTotalAlugueis(),
                carroInfo.getValorMaximo(),
                carroInfo.getValorMedio()));
    }
}

package com.estudo.jpa.dto;

import com.estudo.jpa.model.Carro;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AluguelCarroInfo {

    private Carro carro;

    private Long totalAlugueis;

    private BigDecimal valorMaximo;

    private BigDecimal valorMedio;

    public AluguelCarroInfo(Carro carro, Long totalAlugueis, Number valorMaximo, Number valorMedio) {

        this.carro = carro;

        this.totalAlugueis = totalAlugueis;

        this.valorMaximo = BigDecimal.valueOf(valorMaximo.doubleValue());

        this.valorMedio = BigDecimal.valueOf(valorMedio.doubleValue());

    }
}

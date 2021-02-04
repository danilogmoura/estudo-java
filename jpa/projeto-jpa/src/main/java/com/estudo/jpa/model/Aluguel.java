package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "aluguel")
public class Aluguel extends EntidadeBaseInteger {

    @CreationTimestamp
    @Column(name = "data_pedido")
    private OffsetDateTime dataPedido;

    @Column(name = "data_entrega")
    private OffsetDateTime dataEntrega;

    @Column(name = "data_devolucao")
    private OffsetDateTime dataDevolucao;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "apolice_seguro_id")
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Motorista motorista;
}

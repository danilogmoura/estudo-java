package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Carro.buscarTodos", query = "SELECT c FROM Carro c"),
        @NamedQuery(name = "Carro.buscarCarroComAcessorios", query = "SELECT c FROM Carro c join c.acessorios WHERE c.id =: id")
})

@Setter
@Getter
@Entity
public class Carro extends EntidadeBaseInteger {

    private String placa;

    private String chassi;

    private String cor;

    @Column(name = "valor_diaria")
    private BigDecimal valorDiaria;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id")
    private ModeloCarro modeloCarro;

    @ManyToMany
    @JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "carro_id"), inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private List<Acessorio> acessorios;

    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;

}

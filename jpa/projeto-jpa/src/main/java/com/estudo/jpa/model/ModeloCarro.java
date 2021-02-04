package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "modelo_carro")
public class ModeloCarro extends EntidadeBaseInteger {

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    private Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}

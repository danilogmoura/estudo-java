package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa extends EntidadeBaseInteger {

    private String nome;

    @Column(name = "data_nascimento")
    private OffsetDateTime dataNascimento;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}

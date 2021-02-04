package com.estudo.jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Acessorio extends EntidadeBaseInteger {

    private String descricao;
}

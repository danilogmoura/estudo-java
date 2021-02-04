package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "fabricante")
public class Fabricante extends EntidadeBaseInteger {

    private String nome;

}

package com.estudo.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("FUNCIONARIO")
public class Funcionario extends Pessoa {

	private String matricula;

}

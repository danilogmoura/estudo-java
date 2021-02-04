package com.estudo.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("MOTORISTA")
public class Motorista extends Pessoa {

	@Column(name = "numero_cnh")
	private String numeroCNH;

}

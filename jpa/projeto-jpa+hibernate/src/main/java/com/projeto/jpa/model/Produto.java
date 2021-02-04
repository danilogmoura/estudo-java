package com.projeto.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

}

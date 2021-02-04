package com.dmg.aifood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.dmg.aifood.domain.model.Restaurante;

public interface RestauranteRepositoryQueires {
	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
}
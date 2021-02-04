package com.dmg.jpahibernate.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

public class AlteracaoRestaurante {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante = new Restaurante();
		restaurante.setId(2L);
		restaurante.setNome("Frigideira");
		restaurante.setTaxaFrete(new BigDecimal(44.12));

		restaurante = restaurantes.adicionar(restaurante);

		System.out.printf("%d - %s, taxa de entrega: R$%.2f", restaurante.getId(), restaurante.getNome(),
				restaurante.getTaxaFrete());
	}

}

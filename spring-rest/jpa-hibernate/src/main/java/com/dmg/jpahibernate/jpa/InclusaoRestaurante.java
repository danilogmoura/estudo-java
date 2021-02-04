package com.dmg.jpahibernate.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

public class InclusaoRestaurante {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Pabela Quente");
		restaurante1.setTaxaFrete(new BigDecimal(9.99));

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Franco Assado");
		restaurante2.setTaxaFrete(new BigDecimal(1.87));

		restaurante1 = restaurantes.adicionar(restaurante1);
		restaurante2 = restaurantes.adicionar(restaurante2);

		System.out.printf("%d - %s, taxa de entrega: R$%.2f\n", restaurante1.getId(), restaurante1.getNome(),
				restaurante1.getTaxaFrete());

		System.out.printf("%d - %s, taxa de entrega: R$%.2f\n", restaurante2.getId(), restaurante2.getNome(),
				restaurante2.getTaxaFrete());

	}
}

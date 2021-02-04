package com.dmg.jpahibernate.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

public class BuscarRestaurante {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		List<Restaurante> todosRestaurantes = restaurantes.todos();

		todosRestaurantes.forEach(restaurante -> {
			System.out.printf("%d - %s (%s), taxa de entrega: R$%.2f\n", restaurante.getId(), restaurante.getNome(),
					restaurante.getCozinha().getNome(), restaurante.getTaxaFrete());
		});
	}
}

package com.dmg.jpahibernate.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

public class ExclusaoRestaurante {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);

		restaurantes.remover(restaurante);
	}
}

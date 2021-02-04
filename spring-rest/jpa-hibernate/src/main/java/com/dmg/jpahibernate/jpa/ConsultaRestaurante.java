package com.dmg.jpahibernate.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Restaurante;
import com.dmg.jpahibernate.domain.repository.RestauranteRepository;

public class ConsultaRestaurante {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = restaurantes.porId(3l);
		Restaurante restaurante2 = restaurantes.porId(5l);

		System.out.printf("%d - %s (%s), taxa de entrega: R$%.2f\n", restaurante1.getId(), restaurante1.getNome(),
				restaurante1.getCozinha().getNome(), restaurante1.getTaxaFrete());

		System.out.printf("%d - %s (%s), taxa de entrega: R$%.2f\n", restaurante2.getId(), restaurante2.getNome(),
				restaurante2.getCozinha().getNome(), restaurante2.getTaxaFrete());
	}

}

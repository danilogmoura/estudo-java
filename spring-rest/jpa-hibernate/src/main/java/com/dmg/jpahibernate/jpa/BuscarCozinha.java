package com.dmg.jpahibernate.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Cozinha;
import com.dmg.jpahibernate.domain.repository.CozinhaRepository;

public class BuscarCozinha {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		List<Cozinha> todasCozinhas = cozinhas.todas();

		for (Cozinha cozinha : todasCozinhas) {
			System.out.println(cozinha.getNome());
		}
	}

}

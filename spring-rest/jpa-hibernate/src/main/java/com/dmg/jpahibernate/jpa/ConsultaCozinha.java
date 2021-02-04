package com.dmg.jpahibernate.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Cozinha;
import com.dmg.jpahibernate.domain.repository.CozinhaRepository;

public class ConsultaCozinha {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha = cozinhas.porId(2L);

		System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
	}

}

package com.dmg.jpahibernate.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.dmg.jpahibernate.JpaHibernateApplication;
import com.dmg.jpahibernate.domain.model.Cozinha;
import com.dmg.jpahibernate.domain.repository.CozinhaRepository;

public class InclusaoCozinha {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(JpaHibernateApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Italiana");

		cozinha1 = cozinhas.adicionar(cozinha1);

		cozinha2 = cozinhas.adicionar(cozinha2);

		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}

}

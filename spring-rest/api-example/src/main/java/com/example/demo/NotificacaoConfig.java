package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.email2.com");
		notificadorEmail.setCaixaAlta(true);
		return notificadorEmail;
	}

}

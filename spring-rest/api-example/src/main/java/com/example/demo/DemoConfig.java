package com.example.demo;

import org.springframework.context.annotation.Bean;

import com.example.demo.di.notificacao.NotificadorEmail;
import com.example.demo.di.service.AtivacaoClienteService;

//@Configuration
public class DemoConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.email.com");
		notificadorEmail.setCaixaAlta(false);
		return notificadorEmail;

	}

	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(this.notificadorEmail());
	}

}

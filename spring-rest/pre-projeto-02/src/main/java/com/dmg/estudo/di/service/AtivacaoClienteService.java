package com.dmg.estudo.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.dmg.estudo.di.modelo.Cliente;

@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		// diz ao container que o cliente está ativo

		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

}

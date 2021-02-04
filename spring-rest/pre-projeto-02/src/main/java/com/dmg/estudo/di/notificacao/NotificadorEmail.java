package com.dmg.estudo.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dmg.estudo.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	@Autowired
	private NotificadorProperties properties;

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("host: " + properties.getHostServidor());
		System.out.println("port: " + properties.getPortaServidor());

		System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);

	}
}

package com.dmg.aifood.di.notificacao;

import org.springframework.stereotype.Component;

import com.dmg.aifood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
//@Primary
//@Qualifier("urgente")
@Component
public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", cliente.getNome(),
				cliente.getTelefone(), mensagem);

	}
}
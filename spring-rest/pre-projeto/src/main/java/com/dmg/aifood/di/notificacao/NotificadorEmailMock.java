package com.dmg.aifood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.dmg.aifood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//@Primary
//@Qualifier("normal")
@Component
public class NotificadorEmailMock implements Notificador {

	public NotificadorEmailMock() {
		System.out.println("NotificadorEmailMock MOCK");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("MOCK: Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(),
				mensagem);
	}

}

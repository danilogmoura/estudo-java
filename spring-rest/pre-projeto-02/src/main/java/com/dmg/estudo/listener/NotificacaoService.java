package com.dmg.estudo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.dmg.estudo.di.notificacao.NivelUrgencia;
import com.dmg.estudo.di.notificacao.Notificador;
import com.dmg.estudo.di.notificacao.TipoDoNotificador;
import com.dmg.estudo.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {

	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;

	@EventListener
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}

}

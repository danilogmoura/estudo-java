package com.exemplo.di.service;

import com.exemplo.di.modelo.Cliente;
import com.exemplo.di.noticacao.Notificador;

public class AtivacaoClienteService {

	private Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

}

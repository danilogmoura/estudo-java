package com.example.demo.di.service;

import com.example.demo.di.modelo.Cliente;
import com.example.demo.di.notificacao.Notificador;

//@Component
public class AtivacaoClienteService {

	private Notificador notificador;

	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo!");
	}

}

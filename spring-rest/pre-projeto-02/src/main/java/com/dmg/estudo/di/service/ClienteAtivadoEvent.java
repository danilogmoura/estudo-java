package com.dmg.estudo.di.service;

import com.dmg.estudo.di.modelo.Cliente;

public class ClienteAtivadoEvent {

	private Cliente cliente;

	public ClienteAtivadoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

}

package com.exemplo.di.service;

import com.exemplo.di.modelo.Cliente;
import com.exemplo.di.modelo.Produto;
import com.exemplo.di.noticacao.Notificador;

public class EmissaoNotaFiscalService {

	private Notificador notificador;

	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}

	public void emitir(Cliente cliente, Produto produto) {
		// TODO emite uma nota fiscal...

		this.notificador.notificar(cliente, "Nota fiscal do produto " + produto.getNome() + " foi emitida.");
	}

}

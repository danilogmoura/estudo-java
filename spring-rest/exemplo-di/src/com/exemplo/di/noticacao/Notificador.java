package com.exemplo.di.noticacao;

import com.exemplo.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
}

package com.dmg.estudo.di.notificacao;

import com.dmg.estudo.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}
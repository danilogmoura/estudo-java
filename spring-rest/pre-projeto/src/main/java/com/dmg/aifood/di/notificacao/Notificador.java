package com.dmg.aifood.di.notificacao;

import com.dmg.aifood.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}
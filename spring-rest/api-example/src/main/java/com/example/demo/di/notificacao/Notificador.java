package com.example.demo.di.notificacao;

import com.example.demo.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}
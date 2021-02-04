package com.exemplo.di;

import com.exemplo.di.modelo.Cliente;
import com.exemplo.di.noticacao.NotificadorEmail;
import com.exemplo.di.noticacao.NotificadorSMS;
import com.exemplo.di.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		Cliente danilo = new Cliente("Danilo", "danilo@email.com", "123123131");
		Cliente sophia = new Cliente("Sophia", "sophia@email.com", "123123131");

		AtivacaoClienteService ativacaoClienteEmail = new AtivacaoClienteService(new NotificadorEmail());
		AtivacaoClienteService ativacaoClienteSMS = new AtivacaoClienteService(new NotificadorSMS());

		ativacaoClienteEmail.ativar(danilo);
		ativacaoClienteSMS.ativar(sophia);
	}

}

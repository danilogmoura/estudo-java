package com.dmg.aifood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dmg.aifood.di.modelo.Cliente;
import com.dmg.aifood.di.notificacao.NivelUrgencia;
import com.dmg.aifood.di.notificacao.Notificador;
import com.dmg.aifood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
//	@Qualifier("urgente")
//	@Qualifier("SMS")
//	@Qualifier("email")
	@Autowired
	private Notificador notificador;

//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}

//	@Autowired(required = false)
//	private List<Notificador> notificadores;

//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}

//	public AtivacaoClienteService(String qualquerCoisa) {
//		// TODO Auto-generated constructor stub
//	}

//	@PostConstruct
	public void init() {
		System.out.println("INIT " + notificador);
	}

//	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");

//		for (Notificador notificador : notificadores) {
//			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
//		}

//		if (notificador != null) {
//			this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo!");
//		} else {
//			System.out.println("Não existe notificador, mas cliente foi ativado");
//		}

	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}

}

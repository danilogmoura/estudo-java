package com.dmg.aifood;

import com.dmg.aifood.di.service.AtivacaoClienteService;

//@Configuration
public class ServiceConfig {

//	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService();
	}
}

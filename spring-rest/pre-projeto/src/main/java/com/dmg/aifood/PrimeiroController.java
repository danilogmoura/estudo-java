package com.dmg.aifood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmg.aifood.di.modelo.Cliente;
import com.dmg.aifood.di.service.AtivacaoClienteService;

/**
 * @author Danilo
 *
 */
@Controller
public class PrimeiroController {

	private AtivacaoClienteService ativarCliente;

	public PrimeiroController(AtivacaoClienteService ativar) {
		this.ativarCliente = ativar;
	}

	@GetMapping("ola")
	@ResponseBody
	public String ola() {
		Cliente cliente = new Cliente("Sophia", "sophia@email.com", "(11) 123123123");
		ativarCliente.ativar(cliente);

		return "Olá";
	}

}

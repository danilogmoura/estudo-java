package com.dmg.aifood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmg.aifood.domain.exception.CozinhaNaoEncontradaException;
import com.dmg.aifood.domain.exception.EntidadeEmUsoException;
import com.dmg.aifood.domain.model.Cozinha;
import com.dmg.aifood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIT_backup {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Uruguaiana");

		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);

		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		Exception exception = assertThrows(ConstraintViolationException.class,
				() -> cadastroCozinha.salvar(novaCozinha));

		String expectedMessage = "must not be blank";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		assertThrows(EntidadeEmUsoException.class, () -> cadastroCozinha.remover(1L));
	}

	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		assertThrows(CozinhaNaoEncontradaException.class, () -> cadastroCozinha.remover(100L));
	}
}

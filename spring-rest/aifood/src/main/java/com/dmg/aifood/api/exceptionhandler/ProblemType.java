package com.dmg.aifood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),

	ERRO_DE_SISTEMA("/erro-de-sistema", "Erro no sistema"),

	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrada"),

	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),

	ERRO_NEGOCIO("/negocio", "Violação de regra de negócio"),

	MENSAGEM_INCOMPREENSIVEL("/mesagem-inconpreensivel", "Mensagem imcompreensível"),

	PARAMETRO_INVALIDO("/parametro-invalido", "Parametro inválido");

	private String title;
	private String uri;

	private ProblemType(String path, String title) {
		this.uri = "https://aifood.com" + path;
		this.title = title;
	}
}

CREATE TABLE apolice_seguro (
	id SERIAL,
	valor_franquia NUMERIC(10,2),
	protecao_terceiro BOOLEAN,
	protecao_causas_naturais BOOLEAN,
	protecao_roubo BOOLEAN,
	CONSTRAINT pk_apolice_seguro PRIMARY KEY (id)
);

CREATE TABLE aluguel (
	id SERIAL,
	data_pedido DATE,
	data_entrega TIMESTAMP,
	data_devolucao TIMESTAMP,
	valor_total NUMERIC(10,2),
	carro_id BIGINT NOT NULL,
	apolice_seguro_id BIGINT NOT NULL,
	CONSTRAINT pk_aluguel PRIMARY KEY (id),
	CONSTRAINT fk_aluguel_carro FOREIGN KEY (carro_id) REFERENCES carro (id),
	CONSTRAINT fk_aluguel_apolice_seguro FOREIGN KEY (apolice_seguro_id) REFERENCES apolice_seguro (id)
);
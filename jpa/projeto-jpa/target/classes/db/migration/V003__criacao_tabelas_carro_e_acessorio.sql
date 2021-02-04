CREATE TABLE carro (
	id SERIAL,
	placa VARCHAR(12) NOT NULL,
	chassi VARCHAR(12) NOT NULL,
	cor VARCHAR(12) NOT NULL,
	valor_diaria NUMERIC(10,2) NOT NULL,
	modelo_carro_id BIGINT NOT NULL,
	CONSTRAINT pk_carro PRIMARY KEY (id),
	CONSTRAINT fk_carro_modelo_carro FOREIGN KEY (modelo_carro_id) REFERENCES modelo_carro (id)
);

CREATE TABLE acessorio (
	id SERIAL,
	descricao VARCHAR(50),
	CONSTRAINT pk_acessorio PRIMARY KEY (id)
);

CREATE TABLE carro_acessorio (
	carro_id BIGINT NOT NULL,
	acessorio_id BIGINT NOT NULL,
	CONSTRAINT pk_carro_acessorio PRIMARY KEY (carro_id, acessorio_id)
);
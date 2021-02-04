CREATE TABLE pessoa (
	id SERIAL,
	nome VARCHAR(120) NOT NULL,
	data_nascimento TIMESTAMP,
	cpf VARCHAR(14) NOT NULL,
	sexo VARCHAR(10) NOT NULL,
	tipo_pessoa VARCHAR(30) NOT NULL,
	numero_cnh VARCHAR(30),
	matricula VARCHAR(30),
	CONSTRAINT pk_pessoa PRIMARY KEY (id)
);

CREATE TABLE modelo_carro (
    id SERIAL,
    descricao VARCHAR(30) NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    fabricante_id BIGINT NOT NULL,
    CONSTRAINT pk_modelo_carro PRIMARY KEY (id),
    CONSTRAINT fk_modelo_carro_fabricante FOREIGN KEY (fabricante_id) REFERENCES fabricante (id)
);
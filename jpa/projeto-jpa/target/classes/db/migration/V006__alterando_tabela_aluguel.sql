ALTER TABLE aluguel
    ADD COLUMN pessoa_id BIGINT NOT NULL,
    ADD	CONSTRAINT fk_aluguel_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);
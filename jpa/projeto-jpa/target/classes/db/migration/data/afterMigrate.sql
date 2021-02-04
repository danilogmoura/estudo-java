TRUNCATE fabricante RESTART IDENTITY CASCADE;
TRUNCATE modelo_carro RESTART IDENTITY CASCADE;
TRUNCATE acessorio RESTART IDENTITY CASCADE;
TRUNCATE carro RESTART IDENTITY CASCADE;
TRUNCATE carro_acessorio RESTART IDENTITY CASCADE;
TRUNCATE apolice_seguro RESTART IDENTITY CASCADE;
TRUNCATE aluguel RESTART IDENTITY CASCADE;
TRUNCATE pessoa RESTART IDENTITY CASCADE;

INSERT INTO fabricante (nome) VALUES ('Mercedes-Benz');
INSERT INTO fabricante (nome) VALUES ('Toyota');
INSERT INTO fabricante (nome) VALUES ('Chevrolet');

INSERT INTO modelo_carro (descricao, categoria, fabricante_id) VALUES ('Mercedes-AMG GT 63 S 4MATIC+', 'SEDAN_GRANDE', 1);
INSERT INTO modelo_carro (descricao, categoria, fabricante_id) VALUES ('S10 Cabine Dupla', 'ESPORTIVO', 3);
INSERT INTO modelo_carro (descricao, categoria, fabricante_id) VALUES ('Onix', 'HATCH_MEDIO', 3);

INSERT INTO acessorio (descricao) VALUES ('Santo ântonio');
INSERT INTO acessorio (descricao) VALUES ('Vidro elétrico/ Trava / Alarme');
INSERT INTO acessorio (descricao) VALUES ('Protetor de carter');
INSERT INTO acessorio (descricao) VALUES ('Engate');
INSERT INTO acessorio (descricao) VALUES ('Ar condicionado');

INSERT INTO carro (placa, chassi, cor, valor_diaria, modelo_carro_id ) VALUES ('ADS-2131', 'AD73452CW', 'branco', 5.99, 1);
INSERT INTO carro (placa, chassi, cor, valor_diaria, modelo_carro_id ) VALUES ('HDV-7684', 'F12F18065', 'preto', 8.99, 2);
INSERT INTO carro (placa, chassi, cor, valor_diaria, modelo_carro_id ) VALUES ('WTY-2784', 'VQ12TGDS3', 'azul perola', 5.99, 3);

INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 1);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (1, 3);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (2, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 2);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 4);
INSERT INTO carro_acessorio (carro_id, acessorio_id) VALUES (3, 5);

INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo) VALUES (1500.27, TRUE, FALSE, TRUE);
INSERT INTO apolice_seguro (valor_franquia, protecao_terceiro, protecao_causas_naturais, protecao_roubo) VALUES (2782.27, TRUE, TRUE, TRUE);

INSERT INTO pessoa (nome, data_nascimento, cpf, sexo, tipo_pessoa, numero_cnh) VALUES ('Danilo', timezone('UTC', now()), '111.222.333-44', 'MASCULINO', 'MOTORISTA', '132.414.124-32');
INSERT INTO pessoa (nome, data_nascimento, cpf, sexo, tipo_pessoa, matricula) VALUES ('Sophia', timezone('UTC', now()), '333.444.555-66', 'MASCULINO', 'FUNCIONARIO', 'GSE-131.3123');
INSERT INTO pessoa (nome, data_nascimento, cpf, sexo, tipo_pessoa, matricula) VALUES ('Nathalia', timezone('UTC', now()), '777.888.999-00', 'OUTROS', 'FUNCIONARIO', 'FWG-231.3123');
INSERT INTO pessoa (nome, data_nascimento, cpf, sexo, tipo_pessoa, numero_cnh) VALUES ('Luiz', timezone('UTC', now()), '111.888.333-22', 'OUTROS', 'MOTORISTA', '645.845.124-89');

INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, carro_id, apolice_seguro_id, pessoa_id) VALUES (now() at time zone 'utc', now() at time zone 'utc', now() at time zone 'utc', 45.3, 1, 2, 1);
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, carro_id, apolice_seguro_id, pessoa_id) VALUES (now() at time zone 'utc', now() at time zone 'utc', now() at time zone 'utc', 15.3, 2, 1, 1);
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, carro_id, apolice_seguro_id, pessoa_id) VALUES (now() at time zone 'utc', now() at time zone 'utc', now() at time zone 'utc', 51.3, 3, 1, 1);
INSERT INTO aluguel (data_pedido, data_entrega, data_devolucao, valor_total, carro_id, apolice_seguro_id, pessoa_id) VALUES (now() at time zone 'utc', now() at time zone 'utc', now() at time zone 'utc', 21.3, 3, 1, 4);

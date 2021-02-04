INSERT INTO cozinha (id, nome) VALUES (1, 'Tailandesa');
INSERT INTO cozinha (id, nome) VALUES (2, 'Indiana');
INSERT INTO cozinha (id, nome) VALUES (3, 'Brasileira');

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('A Cozinha', 13, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Cesto Oceânico', 25, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('A Cremoseria', 9.45, 3);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Alquimia', 3.23, 3);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) VALUES ('Armazém do Chefe', 18.99, 2);

INSERT INTO permissao (nome, descricao) VALUES ('Editar-Fatura', 'Permissão para edição das faturas');
INSERT INTO permissao (nome, descricao) VALUES ('Adicionar-Usuario', 'Permissão para adicionar um novo usuário ao sistema');
INSERT INTO permissao (nome, descricao) VALUES ('Visualisar-Historico', 'Permissão para visualizar o log do sistema');
INSERT INTO permissao (nome, descricao) VALUES ('Modulo-Contas-Pagar', 'Permissão para usar o módulo contas a pagar');

INSERT INTO forma_pagamento (descricao) VALUES ('Cartao-Credito');
INSERT INTO forma_pagamento (descricao) VALUES ('Boleto');
INSERT INTO forma_pagamento (descricao) VALUES ('Transferencia');

INSERT INTO estado (id, nome) VALUES (1, 'São Paulo');
INSERT INTO estado (id, nome) VALUES (2, 'Manus');
INSERT INTO estado (id, nome) VALUES (3, 'Minas Gerais');

INSERT INTO cidade (nome, estado_id) VALUES ('Sumaré', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Campinas', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Americana', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Tefé', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Juruá', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Barcelos', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Ouro Preto', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Contagem', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Mariana', 3);
TRUNCATE cozinha RESTART IDENTITY CASCADE;
TRUNCATE restaurante RESTART IDENTITY CASCADE;
TRUNCATE permissao RESTART IDENTITY CASCADE;
TRUNCATE estado RESTART IDENTITY CASCADE;
TRUNCATE cidade RESTART IDENTITY CASCADE;
TRUNCATE restaurante_forma_pagamento RESTART IDENTITY CASCADE;
TRUNCATE produto RESTART IDENTITY CASCADE;

INSERT INTO estado (nome) VALUES ('São Paulo');
INSERT INTO estado (nome) VALUES ('Manaus');
INSERT INTO estado (nome) VALUES ('Minas Gerais');

INSERT INTO cidade (nome, estado_id) VALUES ('Sumaré', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Campinas', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Americana', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Tefé', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Juruá', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Barcelos', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Ouro Preto', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Contagem', 3);
INSERT INTO cidade (nome, estado_id) VALUES ('Mariana', 3);

INSERT INTO cozinha (nome) VALUES ('Tailandesa');
INSERT INTO cozinha (nome) VALUES ('Indiana');
INSERT INTO cozinha (nome) VALUES ('Brasileira');

INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('A Cozinha', now() at time zone 'utc' at time zone 'utc', now() at time zone 'utc', 0, 1, 1, '42346-243', 'Rua Doutor César', '358', 'Bom Retiro', 'Apartamento');
INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('Cesto Oceânico', now() at time zone 'utc', now() at time zone 'utc', 25, 1, 2, '00445-123', 'Rua Tuiuti', '61244', 'Liberdade', null);
INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('A Cremoseria', now() at time zone 'utc', now() at time zone 'utc', 0, 3, 3, '24765-463', 'Praça do Centenário de Vila Prudente', '43', 'São Mateus', null);
INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('Alquimia', now() at time zone 'utc', now() at time zone 'utc', 3.23, 3, 3, '00002-353', 'Rua Heitor Penteado', '1358', 'Freguesia do Ó', 'Estabelecimento Comercial');
INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('Armazém do Chefe', now() at time zone 'utc', now() at time zone 'utc', 18.99, 2, 2, '12564-863', 'Rua Francisca Júlia', '2334', 'São Domingos', null);
INSERT INTO restaurante (nome, data_cadastro, data_atualizacao, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento) VALUES ('Frigideira', now() at time zone 'utc', now() at time zone 'utc', 28.99, 2, 1, '84245-175', 'Alameda Ministro Rocha Azevedo', '2664', 'Capão Redondo', 'Fundos');

INSERT INTO permissao (nome, descricao) VALUES ('Editar-Fatura', 'Permissão para edição das faturas');
INSERT INTO permissao (nome, descricao) VALUES ('Adicionar-Usuario', 'Permissão para adicionar um novo usuário ao sistema');
INSERT INTO permissao (nome, descricao) VALUES ('Visualisar-Historico', 'Permissão para visualizar o log do sistema');
INSERT INTO permissao (nome, descricao) VALUES ('Modulo-Contas-Pagar', 'Permissão para usar o módulo contas a pagar');

INSERT INTO forma_pagamento (descricao) VALUES ('Cartao-Credito');
INSERT INTO forma_pagamento (descricao) VALUES ('Boleto');
INSERT INTO forma_pagamento (descricao) VALUES ('Transferencia');
INSERT INTO forma_pagamento (descricao) VALUES ('Dinheiro');
INSERT INTO forma_pagamento (descricao) VALUES ('Carteira-Digital');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 3);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 4);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2, 3);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2, 4);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3, 4);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (4, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (4, 3);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (5, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (5, 5);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (6, 4);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (6, 2);

INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Batata frita, queijo e molho', 'Poutine', 24.48, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Molho especial feito com especiarias e chocolate', 'Poutine', 24.48, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Carne bovina temperada com ervas aromáticas', 'Pot-au-feu', 24.48, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'A clássica sopa de peixe tailandesa', 'Tom Yum', 24.48, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Arroz branco cozido em leite de coco', 'Nasi Lemak', 24.48, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Um combo de petiscos, incluindo vegetais, frango frito, spring rolls e pasteizinhos', 'Dim Sum', 24.48, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Carne moída cozida com temperos adocicados', 'Bobotie', 24.48, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Lasanha feita com carne moída e berinjela', 'Moussaka', 24.48, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Feita com vegetais e carne ou peixe', 'Solyanka', 24.48, 5);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (true, 'Vegetais, cebolas, ovos e temperos picantes', 'Kottu roti', 24.48, 5);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 1);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 2);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 3);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 4);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 5);
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 6);

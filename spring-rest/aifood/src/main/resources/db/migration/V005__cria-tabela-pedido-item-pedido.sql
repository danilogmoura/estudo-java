create table pedido (
	id serial,
	subtotal numeric(10,2) not null,
	taxa_frete numeric(10,2) not null,
	valor_total numeric(10,2) not null,
	
	data_criacao timestamp not null,
	data_confirmacao timestamp,
	data_cancelamento timestamp,
	data_entrega timestamp,
	
	endereco_cidade_id bigint not null,
	endereco_cep character varying(9) not null,
    endereco_logradouro character varying(100) not null,
    endereco_numero character varying(20) not null,
    endereco_complemento character varying(60),
    endereco_bairro character varying(60) not null,
	
	status_pedido varchar(10) not null,
	forma_pagamento_id bigint not null,
	restaurante_id bigint not null,
	usuario_cliente_id bigint not null,
	primary key (id), 
	
	CONSTRAINT fk_pedido_forma_pagamento FOREIGN KEY (forma_pagamento_id) REFERENCES forma_pagamento (id),
	CONSTRAINT fk_pedido_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante (id),
	CONSTRAINT fk_pedido_usuario_cliente FOREIGN KEY (usuario_cliente_id) REFERENCES usuario (id)
);


create table item_pedido (
	id serial,
	quantidade smallint not null,
	preco_unitario numeric(10,2) not null,
	preco_total numeric(10,2) not null,
	observaco varchar (100),
	produto_id bigint not null,
	pedido_id bigint not null,
	primary key (id), 
	constraint uk_item_pedido_produto unique (pedido_id, produto_id),
  	constraint fk_item_pedido_pedido foreign key (pedido_id) references pedido (id),
  	constraint fk_item_pedido_produto foreign key (produto_id) references produto (id)
);
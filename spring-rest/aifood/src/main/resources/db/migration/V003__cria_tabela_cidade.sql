create table estado (
	id serial,
	nome varchar(80) not null,
	primary key (id)
);

insert into estado (nome) 	select distinct nome_estado 
							from cidade 
							order by nome_estado asc;

alter table cidade 
add column estado_id bigint not null default 0;

update cidade 
set estado_id = (select e.id 
				 from estado e 
				 where e.nome = nome_estado);

alter table cidade 
add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table cidade drop column nome_estado;

alter table cidade rename nome_cidade to nome;
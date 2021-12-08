
create table pessoa (
  id INTEGER NOT NULL,
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  idade INTEGER NOT NULL,
  fonte_renda INTEGER NOT NULL
);

create table empresa (
 	id INTEGER NOT NULL,
 	nome VARCHAR(255) NOT NULL,
 	cnpj VARCHAR(55) NOT NULL,
 	telefone VARCHAR(13) NOT NULL
);

create table divida (
 	id INTEGER NOT NULL,
 	pessoa_id INTEGER NOT NULL,
 	empresa_id INTEGER NOT NULL,
 	valor decimal(12,2) not NULL
);

create table consulta_cpf (
 	id INTEGER NOT NULL,
 	pessoa_id INTEGER NOT NULL,
 	empresa_id INTEGER NOT NULL,
 	data_consulta date not NULL
);

create table bens (
 	id INTEGER NOT NULL,
 	pessoa_id INTEGER NOT NULL,
 	tipo INTEGER NOT NULL,
 	valor decimal(12,2) not NULL
);

create table movimentacao (
 	id INTEGER NOT NULL,
 	pessoa_id INTEGER NOT NULL,
 	tipo INTEGER NOT NULL,
 	valor decimal(12,2) not null,
 	data_movimentacao date not NULL
);
 
 /*Primary key*/
ALTER TABLE pessoa ADD PRIMARY KEY (id);
ALTER TABLE empresa ADD PRIMARY KEY (id);
ALTER TABLE divida ADD PRIMARY KEY (id);
ALTER TABLE consulta_cpf ADD PRIMARY KEY (id);
ALTER TABLE bens ADD PRIMARY KEY (id);
ALTER TABLE movimentacao ADD PRIMARY KEY (id);
 

 /*Sequence*/
create sequence pessoa_seq owned by pessoa.id;
create sequence empresa_seq owned by empresa.id;
create sequence divida_seq owned by divida.id;
create sequence consulta_cpf_seq owned by consulta_cpf.id;
create sequence bens_seq owned by bens.id;
create sequence movimentacao_seq owned by movimentacao.id;
 

 /*Foreing key*/
ALTER TABLE divida ADD CONSTRAINT divida_pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);
ALTER TABLE divida ADD CONSTRAINT divida_empresa_fk FOREIGN KEY (empresa_id) REFERENCES empresa(id);
ALTER TABLE consulta_cpf ADD CONSTRAINT consulta_cpf_pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);
ALTER TABLE consulta_cpf ADD CONSTRAINT consulta_cpf_empresa_fk FOREIGN KEY (empresa_id) REFERENCES empresa(id);
ALTER TABLE bens ADD CONSTRAINT bens_pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);
ALTER TABLE movimentacao ADD CONSTRAINT movimentacao_pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);
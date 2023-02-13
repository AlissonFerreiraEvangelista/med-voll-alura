CREATE TABLE medicos(
    id uuid primary key,
    nome character varying(100) not null,
    email character varying(100) not null unique,
    crm character varying(6) not null unique,
    especialidade character varying(100) not null,
    logradouro character varying(100) not null,
    bairro character varying(100) not null,
    cep character varying(9) not null,
    complemento character varying(100),
    numero character varying(20),
    uf character varying(2) not null,
    cidade character varying(100) not null
);
CREATE TABLE usuarios(
    id uuid primary key,
    login character varying(100) not null unique,
    senha character varying(100) not null  
);
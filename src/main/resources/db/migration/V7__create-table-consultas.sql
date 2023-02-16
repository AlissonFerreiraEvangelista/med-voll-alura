create table consultas(

    id uuid primary key,
    medico_id uuid not null,
    paciente_id uuid not null,
    data date not null,

    constraint fk_consultas_medico_id foreign key(medico_id) references medicos(id),
    constraint fk_consultas_paciente_id foreign key(paciente_id) references pacientes(id)

);
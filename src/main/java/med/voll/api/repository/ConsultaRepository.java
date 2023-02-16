package med.voll.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.consulta.Consulta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
    
}

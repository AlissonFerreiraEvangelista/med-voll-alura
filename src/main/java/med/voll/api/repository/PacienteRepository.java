package med.voll.api.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}

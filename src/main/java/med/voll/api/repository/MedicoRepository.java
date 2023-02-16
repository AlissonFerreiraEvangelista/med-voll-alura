package med.voll.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.medico.Medico;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
   
}

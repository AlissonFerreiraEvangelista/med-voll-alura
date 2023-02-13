package med.voll.api.repository;



import med.voll.api.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
   
}

package med.voll.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.voll.api.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    UserDetails findByLogin(String login);

    
}

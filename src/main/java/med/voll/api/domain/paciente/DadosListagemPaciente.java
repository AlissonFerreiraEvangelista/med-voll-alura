package med.voll.api.domain.paciente;

import java.util.UUID;

public record DadosListagemPaciente(UUID id, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}

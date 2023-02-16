package med.voll.api.domain.paciente;

import java.util.UUID;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(UUID id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}

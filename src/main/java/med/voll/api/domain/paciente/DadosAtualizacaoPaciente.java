package med.voll.api.domain.paciente;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import med.voll.api.domain.endereco.DtoEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        UUID id,
        String nome,
        String telefone,
        DtoEndereco endereco) {
}

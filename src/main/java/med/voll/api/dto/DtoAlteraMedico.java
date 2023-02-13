package med.voll.api.dto;


import java.util.UUID;

import jakarta.validation.constraints.NotNull;


public record DtoAlteraMedico(
    @NotNull
    UUID id,
    String nome,
    String telefone,
    DtoEndereco endereco) {

}

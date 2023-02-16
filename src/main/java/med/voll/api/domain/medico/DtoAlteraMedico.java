package med.voll.api.domain.medico;


import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DtoEndereco;


public record DtoAlteraMedico(
    @NotNull
    UUID id,
    String nome,
    String telefone,
    DtoEndereco endereco) {

}

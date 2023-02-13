package med.voll.api.dto;

import java.util.UUID;

import med.voll.api.entity.Endereco;
import med.voll.api.entity.Medico;
import med.voll.api.enums.Especialidade;

public record DtoDetalhamentoMedico(
    UUID id,
    String nome,
    String email,
    String crm,
    String telefone,
    Especialidade especialidade,
    Endereco endereco
) {
    public DtoDetalhamentoMedico(Medico medico) {
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getTelefone(),medico.getEspecialidade(),medico.getEndereco());
    }
}

package med.voll.api.domain.medico;

import java.util.UUID;

import med.voll.api.domain.endereco.Endereco;

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

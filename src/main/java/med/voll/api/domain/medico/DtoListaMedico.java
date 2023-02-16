package med.voll.api.domain.medico;

import java.util.UUID;

public record DtoListaMedico(
UUID id,
String nome,
String email,
String crm,
Especialidade especialidade

) {

    public DtoListaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}

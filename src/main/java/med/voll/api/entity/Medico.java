package med.voll.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DtoAlteraMedico;
import med.voll.api.dto.DtoCadastroMedico;
import med.voll.api.enums.Especialidade;


import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Medico")
@Table(name = "medicos")
public class Medico {
    
    public Medico(DtoCadastroMedico dto) {
		this.nome = dto.nome();
		this.email = dto.email();
        this.telefone = dto.telefone();
		this.crm = dto.crm();
		this.especialidade = dto.especialidade();
        this.ativo = true;
		this.endereco = new Endereco(dto.endereco());
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    
    private String email;

    private String telefone;
    
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;

    boolean ativo;

    public void atualizaInformacao(DtoAlteraMedico dto) {
        if(dto.nome()!= null){
            this.nome = dto.nome();
        }if(dto.telefone() !=null){
            this.telefone = dto.telefone();
        }if(dto.endereco() != null){
            this.endereco.atualizaInformacao(dto.endereco());
        }
       
    }

    public void inativo() {
        this.ativo= false;
    }

}

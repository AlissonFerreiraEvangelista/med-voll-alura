package med.voll.api.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DtoEndereco;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Endereco {

	
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String complemento;
	private String numero;

	public Endereco(DtoEndereco dto) {
		this.bairro = dto.bairro();
		this.logradouro = dto.logradouro();
		this.cep = dto.cep();
		this.cidade = dto.cidade();
		this.uf = dto.uf();
		this.complemento = dto.complemento();
		this.numero = dto.numero();
	}

	public void atualizaInformacao(DtoEndereco dto) {
		if(dto.logradouro() != null){
			this.logradouro = dto.logradouro();
		}
		if(dto.bairro() != null){
			this.bairro = dto.bairro();
		}
		if(dto.cidade() != null){
			this.cidade = dto.cidade();
		}
		if(dto.cep() != null){
			this.cep = dto.cep();
		}
		if(dto.uf() != null){
			this.uf = dto.uf();
		}
		if(dto.complemento() != null){
			this.complemento = dto.complemento();
		}
		if(dto.numero() != null){
			this.numero = dto.numero();
		}
	}


	
}

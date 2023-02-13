package med.voll.api.dto;

import jakarta.validation.constraints.*;

public record DtoAutenticacao(
    @NotBlank
    @Email
    String login,
    
    @NotBlank
    @Size(min = 3, max = 16)
    String senha
) {
    
}

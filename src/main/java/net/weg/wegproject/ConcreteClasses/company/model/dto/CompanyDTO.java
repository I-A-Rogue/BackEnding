package net.weg.wegproject.ConcreteClasses.company.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    @NotBlank(message = "CNPJ não pode ser vazio")
    @Size(min = 14, max = 14, message = "CNPJ deve ter 14 caracteres")
    private String CNPJ;
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @Email
    @NotBlank(message = "Email não pode ser vazio")
    private String email;
    @NotBlank(message = "Senha não pode ser vazia")
    private String password;
}

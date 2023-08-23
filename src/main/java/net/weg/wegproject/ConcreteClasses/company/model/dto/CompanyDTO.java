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
    @Min(14)
    @Max(14)
    private String CNPJ;
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @Email
    @NotBlank(message = "Email não pode ser vazio")
    private String email;
    @NotBlank(message = "Senha não pode ser vazia")
    private String password;
}

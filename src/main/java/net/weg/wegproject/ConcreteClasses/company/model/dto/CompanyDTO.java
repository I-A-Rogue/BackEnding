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
    @NotNull
    @Min(14)
    @Max(14)
    private String CNPJ;
    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;
}

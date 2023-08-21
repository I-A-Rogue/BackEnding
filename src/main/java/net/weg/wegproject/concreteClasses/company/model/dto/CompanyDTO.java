package net.weg.wegproject.concreteClasses.company.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

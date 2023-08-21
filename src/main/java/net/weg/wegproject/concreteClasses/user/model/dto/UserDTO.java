package net.weg.wegproject.concreteClasses.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @NotNull
    @Min(11)
    @Max(11)
    private Long register; // CPF ou CNPJ

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}

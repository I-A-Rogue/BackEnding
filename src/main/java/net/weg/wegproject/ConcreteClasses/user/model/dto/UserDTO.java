package net.weg.wegproject.ConcreteClasses.user.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @NotBlank(message = "CPF/CNPJ não podem ser nulos")
    private Long cpf; // CPF ou CNPJ
    @NotBlank(message = "Nome não pode ser nulo")
    private String name;
    @NotBlank(message = "Email não pode ser nulo")
    @Email
    private String email;
    @NotBlank(message = "Senha não pode ser nula")
    private String password;
    private List<Address> address;

}

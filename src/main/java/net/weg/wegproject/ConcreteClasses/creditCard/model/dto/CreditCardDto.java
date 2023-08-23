package net.weg.wegproject.ConcreteClasses.creditCard.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDto {
    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    @NotBlank(message = "Data de validade não pode ser vazia")
    private Date validity;
    @NotBlank(message = "Número não pode ser vazio")
    @Size(max = 16, min = 13)
    private String number;
    @NotBlank(message = "CVV não pode ser vazio")
    private Long cvv;
    @NotBlank(message = "Usuário não pode ser vazio")
    private List<User> user;
}
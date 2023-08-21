package net.weg.wegproject.creditCard.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDto {
    @NotNull
    String name;
    @NotNull
    Date validity;
    @NotNull
    @Range(max = 16, min = 13)
    Long number;
    @NotNull
    Long CVV;
    @NotNull
    User user;
}
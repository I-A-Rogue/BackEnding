package net.weg.wegproject.ConcreteClasses.creditCard.model.dto;

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
    @NotNull
    String name;
    @NotNull
    Date validity;
    @NotNull
    @Size(max = 16, min = 13)
    String number;
    @NotNull
    Long cvv;

    private List<User> user;
}
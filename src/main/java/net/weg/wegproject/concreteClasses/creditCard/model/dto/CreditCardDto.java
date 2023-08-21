package net.weg.wegproject.concreteClasses.creditCard.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.user.model.entity.User;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardDto {
    @NotNull
    private String name;

    @NotNull
    private Date validity;

    @NotNull
    @Range(max = 16, min = 13)
    private Long number;

    @NotNull
    private Long CVV;

    @NotNull
    private User user;
}
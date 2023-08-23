package net.weg.wegproject.ConcreteClasses.cart.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartDTO {

    @NotBlank(message = "O preço total não pode ser nulo")
    private Float totalPrice;
    @NotBlank(message = "O tamanho não pode ser nulo")
    private Integer size;
    @NotBlank(message = "O id do usuário não pode ser nulo")
    private List<CartProductQuantity> cartProductQuantities;
}

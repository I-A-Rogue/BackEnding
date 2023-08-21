package net.weg.wegproject.cart.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartDTO {

    float totalPrice;
    @NotNull
    Integer size;
    @OneToMany
    List<ProductDTO> products;
}

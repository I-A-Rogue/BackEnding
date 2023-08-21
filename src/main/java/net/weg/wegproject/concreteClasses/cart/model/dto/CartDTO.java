package net.weg.wegproject.concreteClasses.cart.model.dto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.dto.ProductDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartDTO {

    private Float totalPrice;
    @NotNull
    private Integer size;
    @OneToMany
    private List<ProductDTO> products;
}

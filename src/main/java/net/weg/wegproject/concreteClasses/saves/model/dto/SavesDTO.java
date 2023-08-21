package net.weg.wegproject.concreteClasses.saves.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
public class SavesDTO {
    @NotNull
    private Integer quantity;

    private List<Product> products;
}

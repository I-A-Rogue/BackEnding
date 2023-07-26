package net.weg.wegproject.saves.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wegproject.product.model.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
public class SavesDTO {
    @NotNull
    Integer quantity;

    List<Product> products;
}

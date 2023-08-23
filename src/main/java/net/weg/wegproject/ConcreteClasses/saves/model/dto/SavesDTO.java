package net.weg.wegproject.ConcreteClasses.saves.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

import java.util.List;

@Data
@AllArgsConstructor
public class SavesDTO {
    @NotBlank(message = "Quantidade não pode ser nula")
    private Integer quantity;
    @NotBlank(message = "Lista de produtos não pode ser nula")
    private List<Product> products;
}

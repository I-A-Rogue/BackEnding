package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDTO {

    @NotBlank(message = "O código do produto não pode ser nulo.")
    private Long code;
    @NotBlank(message = "O preço do produto não pode ser nulo.")
    private Float price;
    @NotBlank(message = "A categoria do produto não pode ser nula.")
    private Assessment assessment;
    @NotBlank(message = "A o produto não pode ser nulo.")
    private Motors motors;
    @NotBlank(message = "A imagem do produto não pode ser nula.")
    private String image;
}
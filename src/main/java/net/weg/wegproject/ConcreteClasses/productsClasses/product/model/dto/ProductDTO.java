package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.enums.CategoriesEnums;
import org.hibernate.validator.constraints.UniqueElements;

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
}
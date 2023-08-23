package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.enums.CategoriesEnums;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDTO {

    @NotBlank(message = "O código do produto não pode ser nulo.")
    private Long code;
    @NotBlank(message = "O nome do produto não pode ser nulo.")
    @UniqueElements
    private String name;
    @NotBlank(message = "O preço do produto não pode ser nulo.")
    private Float price;
    @NotBlank(message = "O estoque do produto não pode ser nulo.")
    private Integer stockSize;
    @NotBlank(message = "A aplicação do produto não pode ser nula.")
    private String application;
    @NotBlank(message = "As características do produto não podem ser nulas.")
    private String caracteristics;
    @NotBlank(message = "O opcional do produto não pode ser nulo.")
    private String optional;
    @NotBlank(message = "A descrição do produto não pode ser nula.")
    private String description;
    @NotBlank(message = "A categoria do produto não pode ser nula.")
    private Assessment assessment;
    @NotBlank(message = "A avaliação do produto não pode ser nula.")
    private CategoriesEnums categories;
    private Object object;

}
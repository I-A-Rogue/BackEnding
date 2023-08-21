package net.weg.wegproject.concreteClasses.productsClasses.product.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.enums.CategoriesEnums;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDTO {

    @NotNull
    private Long code;

    @NotNull
    @UniqueElements
    private String name;

    @NotNull
    private Float price;

    @NotNull
    private Integer stockSize;

    @NotNull
    private String description;

    private Assessment assessment;

    private CategoriesEnums categories;

    private Object object;

}
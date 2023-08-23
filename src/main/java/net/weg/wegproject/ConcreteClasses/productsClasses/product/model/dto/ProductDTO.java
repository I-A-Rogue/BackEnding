package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto;

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
    
    @NotNull
   private Long code;
    
    @NotNull
    @UniqueElements
    private String name;
    
    @NotNull
    private Float price;
    
    @NotNull
    private Integer stockSize;

    private String application;

    private String caracteristics;
    
    @NotNull
    private String description;
    
    private Assessment assessment;

    private CategoriesEnums categories;

    private Object object;

}
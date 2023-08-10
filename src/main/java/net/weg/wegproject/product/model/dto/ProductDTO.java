package net.weg.wegproject.product.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.dto.AssessmentDTO;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.ink.model.Ink;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDTO {
    @NotNull
    Long code;
    @NotNull
    @UniqueElements
    String name;
    @NotNull
    float price;
    @NotNull
    Integer stockSize;
    @NotNull
    String description;
    AssessmentDTO assessment;
    CategoriesEnums type;
}
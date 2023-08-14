package net.weg.wegproject.product.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.dto.AssessmentDTO;
import net.weg.wegproject.assessment.model.entity.Assessment;
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.security.model.Security;
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
    Assessment assessment;

    private CategoriesEnums categories;

    private Object object;

}
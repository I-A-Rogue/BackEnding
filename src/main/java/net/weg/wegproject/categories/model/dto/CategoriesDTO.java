package net.weg.wegproject.categories.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.categories.enuns.CategoriesEnums;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoriesDTO {
    @NotNull
    String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    CategoriesEnums type;

}

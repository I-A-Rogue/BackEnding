package net.weg.wegproject.ink.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.InkEnums;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class InkDTO extends ProductDTO {
    @NotNull
    String color;
    @NotNull
    String density;
    @NotNull
    @Enumerated(EnumType.STRING)
    InkEnums type;
    
}

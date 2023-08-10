package net.weg.wegproject.categories.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Data

public abstract class Categories {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    CategoriesEnums type;
}

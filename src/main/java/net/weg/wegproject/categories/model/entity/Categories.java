package net.weg.wegproject.categories.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.categories.enuns.CategoriesEnums;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Categories")

public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    CategoriesEnums type;

}

package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.enums.CategoriesEnums;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    private Long code;

    @Column(nullable = false)
    private String name;

    private Float price;

    private Integer stockSize;

    @Column(nullable = false)
    private String description;

    private CategoriesEnums categories;

    @ManyToOne
    private Assessment assessment;


}
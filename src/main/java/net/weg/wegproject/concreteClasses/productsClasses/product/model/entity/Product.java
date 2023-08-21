package net.weg.wegproject.concreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.enums.CategoriesEnums;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Product")
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
package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.enums.CategoriesEnums;
import org.springframework.boot.ApplicationArguments;

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
    @Column(nullable = false)
    private Float price;
    @Column(nullable = false)
    private Integer stockSize;
    @Column(nullable = false)
    private String application;
    @Column(nullable = false)
    private String caracteristics;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private CategoriesEnums categories;
    @OneToOne(cascade = CascadeType.ALL)
    private Assessment assessment;


}
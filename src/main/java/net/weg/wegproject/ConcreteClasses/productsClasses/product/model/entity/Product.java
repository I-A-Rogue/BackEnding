package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    private Long code;
    @Column(nullable = false)
    private Float price;
    @Column(nullable = false)
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    private Assessment assessment;
    @OneToOne(cascade = CascadeType.ALL)
    private Motors motors;
}
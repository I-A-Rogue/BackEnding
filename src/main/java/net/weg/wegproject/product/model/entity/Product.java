package net.weg.wegproject.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.entity.Assessment;
import net.weg.wegproject.categories.model.entity.Categories;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long code;
    @Column(nullable = false, unique = true)
    String name;
    float price;
    Integer stockSize;
    @Column(nullable = false)
    String description;
    @ManyToOne
    Assessment assessment;
    @OneToOne
    Categories categories;
}
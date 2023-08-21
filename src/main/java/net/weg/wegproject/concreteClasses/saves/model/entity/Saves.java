package net.weg.wegproject.concreteClasses.saves.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToMany
    private List<Product> products;
}

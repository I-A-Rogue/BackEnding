package net.weg.wegproject.ConcreteClasses.saves.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Integer quantity;

    @ManyToMany
    private List<Product> products;
}

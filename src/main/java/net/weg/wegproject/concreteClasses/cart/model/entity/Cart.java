package net.weg.wegproject.concreteClasses.cart.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.concreteClasses.user.model.entity.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float totalPrice;

    @Column(nullable = false)
    private Integer size;

    @ManyToMany
    private List<Product> products;

    @ManyToOne
    private User user;
}

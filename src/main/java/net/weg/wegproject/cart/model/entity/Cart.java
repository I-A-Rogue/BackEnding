package net.weg.wegproject.cart.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.user.model.entity.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    float totalPrice;
    @Column(nullable = false)
    Integer size;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_Product"),
            inverseJoinColumns = @JoinColumn(name = "id_Cart")
    )
    List<Product> products;

    @ManyToOne
    User user;
}

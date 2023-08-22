package net.weg.wegproject.ConcreteClasses.cart.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

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

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private User user;
}

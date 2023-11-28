package net.weg.wegproject.ConcreteClasses.saves.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saves {

    public Saves(User user) {
        this.quantity = 0;
        this.products = null;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    Integer quantity;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;
    @OneToOne(mappedBy = "saves")
    @JsonIgnore
    private User user;
}

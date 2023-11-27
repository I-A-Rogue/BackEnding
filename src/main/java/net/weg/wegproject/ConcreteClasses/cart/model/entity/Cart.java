package net.weg.wegproject.ConcreteClasses.cart.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Cart {

    public Cart(Long id, Float totalPrice, List<CartProductQuantity> products, User user) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.size = products.size();
        this.products = products;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Float totalPrice;
    @Column(nullable = false)
    private Integer size;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProductQuantity> products;
    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", size=" + size +
                '}';
    }
}

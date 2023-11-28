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

    public Cart(User user) {
        this.totalPrice = 0f;
        this.size = 0;
        this.products = null;
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
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
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

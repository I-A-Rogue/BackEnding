package net.weg.wegproject.ConcreteClasses.cart.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartProductQuantityId.class)
public class CartProductQuantity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    Cart cart;

    Integer quantity;

}

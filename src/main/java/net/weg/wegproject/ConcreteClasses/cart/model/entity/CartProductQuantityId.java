package net.weg.wegproject.ConcreteClasses.cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductQuantityId implements Serializable {
    private Long product;
    private Long cart;
}

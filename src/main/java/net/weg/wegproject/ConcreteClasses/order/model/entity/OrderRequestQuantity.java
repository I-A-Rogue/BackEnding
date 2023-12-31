package net.weg.wegproject.ConcreteClasses.order.model.entity;

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
@IdClass(OrderRequestQuantityId.class)
public class OrderRequestQuantity {

        @Id
        @GeneratedValue
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        Product product;
        @Id
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "order_id")
        @JsonIgnore
        OrderRequest order;

        Integer quantity;
}

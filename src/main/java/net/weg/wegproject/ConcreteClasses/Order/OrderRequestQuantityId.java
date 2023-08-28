package net.weg.wegproject.ConcreteClasses.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestQuantityId implements Serializable {
    private Long product;
    private Long order;
}

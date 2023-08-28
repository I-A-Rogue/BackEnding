package net.weg.wegproject.ConcreteClasses.Order.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderRequestQuantity> products;
}

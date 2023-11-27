package net.weg.wegproject.ConcreteClasses.order.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.Date;
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
    @OneToOne
    private User user;
    private String status;
    private Date date;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderRequestQuantity> products;
}

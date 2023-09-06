package net.weg.wegproject.ConcreteClasses.Order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Address address;
    private User user;
    private String status;
    private Date date;
    private List<CartProductQuantity> cartProductQuantities;

}

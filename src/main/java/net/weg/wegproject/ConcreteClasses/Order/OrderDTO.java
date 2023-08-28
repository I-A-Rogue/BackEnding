package net.weg.wegproject.ConcreteClasses.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.CartProductQuantity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Address address;
    private List<CartProductQuantity> cartProductQuantities;

}

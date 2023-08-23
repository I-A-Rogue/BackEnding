package net.weg.wegproject.ConcreteClasses.user.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long cpf;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToOne(cascade = CascadeType.ALL)
    private Saves saves;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @ManyToMany(mappedBy = "user")
    private List<CreditCard> cards;
}

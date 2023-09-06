package net.weg.wegproject.ConcreteClasses.user.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import org.hibernate.validator.constraints.Range;

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
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
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

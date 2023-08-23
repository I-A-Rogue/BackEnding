package net.weg.wegproject.concreteClasses.user.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.concreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.concreteClasses.saves.model.entity.Saves;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_User")

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
    private String address;

    @OneToOne
    private Saves saves;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CreditCard> cards;
}

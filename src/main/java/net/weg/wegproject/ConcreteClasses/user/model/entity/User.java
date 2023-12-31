package net.weg.wegproject.ConcreteClasses.user.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.cart.model.entity.Cart;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.ConcreteClasses.saves.model.entity.Saves;
import net.weg.wegproject.listener.UserEntityListener;
import net.weg.wegproject.security.model.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@EntityListeners(UserEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated

public class User implements UserDetails {

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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Saves saves;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cart cart;

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<CreditCard> cards;

    @Enumerated(EnumType.STRING)
    private List<Profile> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", cards=" + cards +
                ", authorities=" + authorities +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}

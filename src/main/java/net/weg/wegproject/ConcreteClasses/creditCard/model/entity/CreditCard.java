package net.weg.wegproject.ConcreteClasses.creditCard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date validity;
    @Column(nullable = false, unique = true)
    @Size(max = 16, min = 13)
    private String number;
    @Column(nullable = false)
    private Long cvv;
    @ManyToMany
    @JsonIgnore
    private List<User> user;

}
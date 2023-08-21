package net.weg.wegproject.concreteClasses.creditCard.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.concreteClasses.user.model.entity.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(style = "mm/dd")
    private Date validity;

    @Column(nullable = false, unique = true)
    @Range(max = 16, min = 13)
    private Long number;

    @Column(nullable = false)
    @Max(3)
    @Min(3)
    private Long CVV;

    @ManyToOne
    private User user;

}
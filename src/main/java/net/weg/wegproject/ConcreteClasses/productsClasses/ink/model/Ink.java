package net.weg.wegproject.ConcreteClasses.productsClasses.ink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.InkEnums;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ink extends Product {

    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Integer density;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InkEnums type;

    @OneToOne
    @JsonIgnore
    private Product product_ink;

    @Override
    public String toString() {
        return "Ink{" +
                "color='" + color + '\'' +
                ", density=" + density +
                ", type=" + type +
                '}';
    }
}

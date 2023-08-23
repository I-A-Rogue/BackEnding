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
    private String density;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InkEnums type;

    @OneToOne
    @JoinColumn(name = "produto_codigo")
    @JsonIgnore
    private Product produto;

}

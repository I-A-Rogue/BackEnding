package net.weg.wegproject.concreteClasses.productsClasses.ink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/ink/model/Ink.java
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.enums.InkEnums;
import net.weg.wegproject.product.model.entity.Product;
=======
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.InkEnums;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/ink/model/Ink.java

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ink extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String density;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/ink/model/Ink.java
    InkEnums format;
=======
    private InkEnums type;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/ink/model/Ink.java

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code")
    Product product_code;
}

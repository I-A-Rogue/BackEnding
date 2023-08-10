package net.weg.wegproject.ink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.enums.InkEnums;
import net.weg.wegproject.product.model.entity.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Ink")

public class Ink extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String color;
    @Column(nullable = false)
    String density;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    InkEnums format;
}

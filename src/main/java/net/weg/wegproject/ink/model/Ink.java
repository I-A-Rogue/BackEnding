package net.weg.wegproject.ink.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.enums.InkEnums;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Ink")

public class Ink extends Product {

    @Column(nullable = false)
    String color;
    @Column(nullable = false)
    String density;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    InkEnums type;
    
}

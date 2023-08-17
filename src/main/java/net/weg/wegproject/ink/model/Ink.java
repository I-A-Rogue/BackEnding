package net.weg.wegproject.ink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.entity.Assessment;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.enums.InkEnums;
import org.springframework.beans.BeanUtils;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "produto_codigo")
    @JsonIgnore
    private Product produto;

    public Ink(Long code, String name, float price, Integer stockSize, String description, CategoriesEnums categories, Assessment assessment, String color, String density, InkEnums type, Product produto) {
        super(code, name, price, stockSize, description, categories, assessment);
        this.color = color;
        this.density = density;
        this.type = type;
        this.produto = produto;
    }
}

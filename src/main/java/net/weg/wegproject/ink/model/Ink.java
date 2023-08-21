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

    @Override
    public String toString() {
        return "Ink{" +
                "color='" + color + '\'' +
                ", density='" + density + '\'' +
                ", type=" + type +
                "Product{" +
                ", code=" + produto.getCode() +
                ", name='" + produto.getName() + '\'' +
                ", price=" + produto.getPrice() +
                ", stockSize=" + produto.getStockSize() +
                ", description='" + produto.getDescription() + '\'' +
                ", categories=" + produto.getCategories() +
                ", assessment=" + produto.getAssessment() +
                '}';
    }
}

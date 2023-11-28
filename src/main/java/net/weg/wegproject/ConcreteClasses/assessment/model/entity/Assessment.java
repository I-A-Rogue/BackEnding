package net.weg.wegproject.ConcreteClasses.assessment.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer amountVotes;
    @Column(nullable = false)
    private Integer assessment;
    @Column(nullable = false)
    private Integer totalAssessment;
    @OneToOne(mappedBy = "assessment")
    private Product product;

}
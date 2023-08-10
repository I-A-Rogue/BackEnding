package net.weg.wegproject.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.entity.Assessment;
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.security.model.Security;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Product")

public class Product {
    @Id
    private Long code;

    @Column(nullable = false, unique = true)
    private String name;

    float price;

    private Integer stockSize;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Assessment assessment;

    @OneToOne
    private Categories categories;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Motors motors;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Automation automation;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Ink ink;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Building building;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Security security;
}
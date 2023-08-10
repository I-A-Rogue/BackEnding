package net.weg.wegproject.product.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.assessment.model.entity.Assessment;
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.categories.enuns.CategoriesEnums;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.security.model.Security;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.JdbcTypeRegistration;
import org.hibernate.annotations.JdbcTypeRegistrations;

import java.sql.Types;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Product")
@Inheritance(strategy = InheritanceType.JOINED)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long code;
    @Column(nullable = false, unique = true)
    String name;
    @Column(nullable = false)
    float price;
    Integer stockSize;
    @Column(nullable = false)
    String description;
    @ManyToOne
    Assessment assessment;
    @Column(nullable = false)
    CategoriesEnums type;
}
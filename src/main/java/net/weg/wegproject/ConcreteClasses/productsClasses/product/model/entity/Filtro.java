package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.enums.InkEnums;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filtro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float priceMin;
    private Float priceMax;
    private Boolean priceDesc;
    private Boolean priceAsc;
    private InkEnums type;
    private String Categories;

    private Float density;
    private String color;

    private Boolean assesment;

    //  Motors
    private Float power;
    private Float frequencyMin;
    private Float frequencyMax;
    private String material;
    private String  carcass;

    private Float voltage;
    private String rfi;
    private Float temperature;

    private Float voltageMin;
    private Float voltageMax;

    private String plug;
    private String battery;
    private String casing;

    public String getType() {
        return type.name();
    }
}

package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.enums.InkEnums;
import org.springframework.data.repository.query.Param;

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
    private InkEnums type;
    private Integer density;
    private String color;
    private Boolean assesment;
    private Integer power;
    private String material;
    private String  carcass;
    private Float voltage;
    private String rfi;
    private Float temperature;
    private Float voltageMin;
    private Float voltageMax;
    private Float frequencyMin;
    private Float frequencyMax;
    private String plug;
    private String battery;
    private String casing;

    public Filtro(Float priceMin, Float priceMax, InkEnums type, Integer density, String color, Boolean assesment) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.type = type;
        this.density = density;
        this.color = color;
        this.assesment = assesment;
    }

    public Filtro(Float priceMin, Float priceMax, InkEnums type, Integer power, String material, String carcass) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.type = type;
        this.power = power;
        this.material = material;
        this.carcass = carcass;
    }

    public Filtro(Float priceMin, Float priceMax, InkEnums type, Float voltage, String rfi, Float temperature) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.type = type;
        this.voltage = voltage;
        this.rfi = rfi;
        this.temperature = temperature;
    }

    public Filtro(Float priceMin, Float priceMax, InkEnums type, Float voltageMin, Float voltageMax, Float frequencyMin, Float frequencyMax) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.type = type;
        this.voltageMin = voltageMin;
        this.voltageMax = voltageMax;
        this.frequencyMin = frequencyMin;
        this.frequencyMax = frequencyMax;
    }

    public Filtro(Float priceMin, Float priceMax, InkEnums type, String plug, String battery, String casing) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.type = type;
        this.plug = plug;
        this.battery = battery;
        this.casing = casing;
    }



}
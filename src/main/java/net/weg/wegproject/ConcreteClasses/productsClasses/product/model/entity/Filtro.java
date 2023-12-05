package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String Categories;

    private Boolean assesment;

    //  Motors
    private String standard;
    private Integer frequency;
    private List<Integer> nominalTension;
    private List<Integer> poles;
    private List<Double> powerHP;
    private String codeDaCarcaca;
    private String typeDaCarcaca;
    private List<Double> ipIn;
    private List<Double> conjugateFromStart;
    private List<Double> maximumConjugate;
    private Double momentOfInertia;
    private Integer rotorTimeBlocked;
    private Double weight;
    private Integer noiseLevel;
    private Double factorOfService;
    private List<Integer> nominalRotation;
    private Double income50;
    private Double income75;
    private Double income100;
    private Double powerfactor50;
    private Double powerfactor75;
    private Double powerfactor100;
    private List<Double> nominalchain;
    private Integer altitude;
    private String regime;
    private Integer temperatureMin;
    private Integer temperatureMax;
    private String protection;
    private String model;
    private List<Double> conjugateNominal;
}

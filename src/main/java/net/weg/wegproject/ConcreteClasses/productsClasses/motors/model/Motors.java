package net.weg.wegproject.ConcreteClasses.productsClasses.motors.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Motors {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long code;
    @Column(nullable = false)
    private String standard;
    @Column(nullable = false)
    private Integer frequency;
    @Column(nullable = false)
    private ArrayList<Integer> nominalTension;
    @Column(nullable = false)
    private List<Integer> poles;
    @Column(nullable = false)
    private List<Double> powerHP;
    @Column(nullable = false)
    private String codeDaCarcaca;
    @Column(nullable = false)
    private String typeDaCarcaca;
    @Column(nullable = false)
    private List<Double> ipIn;
    @Column(nullable = false)
    private List<Double> conjugateFromStart;
    @Column(nullable = false)
    private List<Double> maximumConjugate;
    @Column(nullable = false)
    private Double momentOfInertia;
    @Column(nullable = false)
    private Integer rotorTimeBlocked;
    @Column(nullable = false)
    private Double weight;
    private Integer noiseLevel;
    @Column(nullable = false)
    private Double factorOfService;
    @Column(nullable = false)
    private List<Integer> nominalRotation;
    @Column(nullable = false)
    private Double income50;
    @Column(nullable = false)
    private Double income75;
    @Column(nullable = false)
    private Double income100;
    @Column(nullable = false)
    private Double powerfactor50;
    @Column(nullable = false)
    private Double powerfactor75;
    @Column(nullable = false)
    private Double powerfactor100;
    @Column(nullable = false)
    private List<Double> nominalchain;
    @Column(nullable = false)
    private Integer altitude;
    @Column(nullable = false)
    private String regime;
    @Column(nullable = false)
    private Integer temperatureMin;
    @Column(nullable = false)
    private Integer temperatureMax;
    @Column(nullable = false)
    private String protection;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private List<Double> conjugateNominal;
    @OneToOne(mappedBy = "motors", cascade = CascadeType.ALL)
    @JsonIgnore
    private Product product;

    @Override
    public String toString() {
        return "Motors{" +
                "standard='" + standard + '\'' +
                ", frequency=" + frequency +
                ", nominalTension=" + nominalTension +
                ", poles=" + poles +
                ", powerHP=" + powerHP +
                ", codeDaCarcaca='" + codeDaCarcaca + '\'' +
                ", typeDaCarcaca='" + typeDaCarcaca + '\'' +
                ", ipIn=" + ipIn +
                ", conjugateFromStart=" + conjugateFromStart +
                ", maximumConjugate=" + maximumConjugate +
                ", momentOfInertia=" + momentOfInertia +
                ", rotorTimeBlocked=" + rotorTimeBlocked +
                ", weight=" + weight +
                ", noiseLevel=" + noiseLevel +
                ", factorOfService=" + factorOfService +
                ", nominalRotation=" + nominalRotation +
                ", income50=" + income50 +
                ", income75=" + income75 +
                ", income100=" + income100 +
                ", powerfactor50=" + powerfactor50 +
                ", powerfactor75=" + powerfactor75 +
                ", powerfactor100=" + powerfactor100 +
                ", nominalchain=" + nominalchain +
                ", altitude=" + altitude +
                ", regime='" + regime + '\'' +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                ", protection='" + protection + '\'' +
                ", model='" + model + '\'' +
                ", conjugateNominal=" + conjugateNominal +
                '}';
    }
}
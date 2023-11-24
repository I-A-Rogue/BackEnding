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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String standard;
    private Integer frequency;
    private ArrayList<Integer> nominalTension;
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
    private String image;
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
                ", image='" + image + '\'' +
                ", conjugateNominal=" + conjugateNominal +
                '}';
    }
}
package net.weg.wegproject.ConcreteClasses.productsClasses.motors.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Motors extends Product {

    private String standard;
    private String frequency;
    private String nominalTension;
    private String poles;
    private String powerHP;
    private String codeDaCarcaca;
    private String typeDaCarcaca;
    private String ipIn;
    private String conjugateFromStart;
    private String maximumConjugate;
    private String momentOfInertia;
    private String rotorTimeBlocked;
    private String weight;
    private String noiseLevel;
    private String factorOfService;
    private String nominalRotation;
    private String income50;
    private String income75;
    private String income100;
    private String powerfactor50;
    private String powerfactor75;
    private String powerfactor100;
    private String nominalchain;
    private String altitude;
    private String regime;
    private String roomTemperature;
    private String protection;
    private String model;
    private String image;
    private String conjugateNominal;

    @Override
    public String toString() {
        return "Motors{" +
                "standard='" + standard + '\'' +
                ", frequency='" + frequency + '\'' +
                ", nominalTension='" + nominalTension + '\'' +
                ", poles='" + poles + '\'' +
                ", powerHP='" + powerHP + '\'' +
                ", codeDaCarcaca='" + codeDaCarcaca + '\'' +
                ", typeDaCarcaca='" + typeDaCarcaca + '\'' +
                ", ipIn='" + ipIn + '\'' +
                ", conjugateFromStart='" + conjugateFromStart + '\'' +
                ", maximumConjugate='" + maximumConjugate + '\'' +
                ", momentOfInertia='" + momentOfInertia + '\'' +
                ", rotorTimeBlocked='" + rotorTimeBlocked + '\'' +
                ", weight='" + weight + '\'' +
                ", noiseLevel='" + noiseLevel + '\'' +
                ", factorOfService='" + factorOfService + '\'' +
                ", nominalRotation='" + nominalRotation + '\'' +
                ", income50='" + income50 + '\'' +
                ", income75='" + income75 + '\'' +
                ", income100='" + income100 + '\'' +
                ", powerfactor50='" + powerfactor50 + '\'' +
                ", powerfactor75='" + powerfactor75 + '\'' +
                ", powerfactor100='" + powerfactor100 + '\'' +
                ", nominalchain='" + nominalchain + '\'' +
                ", altitude='" + altitude + '\'' +
                ", regime='" + regime + '\'' +
                ", roomTemperature='" + roomTemperature + '\'' +
                ", protection='" + protection + '\'' +
                ", model='" + model + '\'' +
                ", image='" + image + '\'' +
                ", conjugateNominal='" + conjugateNominal + '\'' +
                '}';
    }
}
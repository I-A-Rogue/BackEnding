package net.weg.wegproject.ConcreteClasses.productsClasses.motors.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.IsolationClass;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Motors extends Product {

    @Column(nullable = false)
    private String carcass;

    @Column(nullable = false)
    private String materialCarcass;

    @Column(nullable = false)
    private Float power; //(Quilowatt (Kw))

    @Column(nullable = false)
    private Integer frequency; //(hertz(Hz))

    @Column(nullable = false)
    private Float performance; //(baseado em 100% carga)

    @Column(nullable = false)
    private Float powerFactor; //(baseado em 100% carga)

    @Column(nullable = false)
    private Integer nominalRotation; //(Rotation per minute (Rpm))

    @Column(nullable = false)
    private Float slip; //(Porcentagem (%))

    @Column(nullable = false)
    private Float ratedVoltage; //(Volts  (V))

    @Column(nullable = false)
    private Float nominalChain; //(Ampere (A))

    @Column(nullable = false)
    private Float currentDeparture; //(Ampere (A))

    @Column(nullable = false)
    private Float ipIn; //(Tempo de partida)

    @Column(nullable = false)
    private Float currentEmpty; //(Ampere (A))

    @Column(nullable = false)
    private Float conjugateNominal; //(quilograma-força-metro (kgfm))

    @Column(nullable = false)
    private Float conjugateDeparture; //(Porcentagem (%))

    @Column(nullable = false)
    private Float maximumConjugate; //(Porcentagem (%))

    @Column(nullable = false)
    private String timeRotorLocked; //(Segundo (s))

    @Column(nullable = false)
    private Float momentInertia; //(Quilogrâmetro (kgm))

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IsolationClass classIsolation; //(B (130 C), F (155 C) ou H (180 C))

    @Column(nullable = false)
    private String regimeService; //(ex.: Cont.(S1))

    @Column(nullable = false)
    private Boolean matchMethod; //(Direta ou indireta)

    @Column(nullable = false)
    private Float roomTemperature; //(Graus celsius)

    @Column(nullable = false)
    private Integer altitude; //(Metros (mt))

    @Column(nullable = false)
    private String degreeProtection; //(ex.: IP21)

    @Column(nullable = false)
    private String refrigeration; //(ex.: IC01 - ODP)

    @Column(nullable = false)
    private String ConstructiveWay; //(ex.: F-1/B34R(D))

    @Column(nullable = false)
    private Boolean rotationDirection; //(horário ou anti-horário ¹)

    @Column(nullable = false)
    private Float approximateMass; //(Quilogramas cúbicas (kg))

    @Column(nullable = false)
    private String impregnationMethod; //(ex.: Imersão poliéster)

    @Column(nullable = false)
    private String materialAxis; //(ex.: Aço carbono SAE 1040/45)

    @Column(nullable = false)
    private String painting; //(ex.: Munsell N 1 - fosco 207N)

    @Column(nullable = false)
    private String typeGrounding; //(ex.: Único)

    @Column(nullable = false)
    private String materialBaffleCover;

    @Column(nullable = false)
    private String thermalProtectionWinding;

    @Column(nullable = false)
    private String bearingType; //(ex.:6203 2RS)

    @Column(nullable = false)
    private String bearingLNA; //(ex.:6202 ZZ)

    @Column(nullable = false)
    private String protectorFenolicOverload;

    @Column(nullable = false)
    private String tropicalizedPainting;

}
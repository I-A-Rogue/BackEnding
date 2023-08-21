package net.weg.wegproject.concreteClasses.productsClasses.building.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/building/model/entity/Building.java
import net.weg.wegproject.enums.LanguageAcronyms;
import net.weg.wegproject.product.model.entity.Product;
=======
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.LanguageAcronyms;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/building/model/Building.java

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Building extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String referenceProduct;

    @Column(nullable = false)
    private String codigoInteligente;

    @Column(nullable = false)
    private Integer ratedPower; //(Volt-Ampère (VA))

    @Column(nullable = false)
    private String voltageInput; //(Volts (V))

    @Column(nullable = false)
    private Integer voltageOutput; //(Volts (V))

    @Column(nullable = false)
    private Integer autonomy; //(Minutos (Min))

    @Column(nullable = false)
    private String batterytype;

    @Column(nullable = false)
    private Integer frequency; //(Hertz (Hz))

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageAcronyms language; //(sigla PT-Br..)

    @Column(nullable = false)
    private Float nominalChain; //(Ampere (A))

    @Column(nullable = false)
    private Integer busVoltage; //(Tensão Corrente Contínua (VCC))

    @Column(nullable = false)
    private Integer currentBatteries; //(Ampère-hora (Ah))

    @Column(nullable = false)
    private String typeplug;

    @Column(nullable = false)
    private String casing;

    @Column(nullable = false)
    private String colorStructure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code")
    Product product_code;
}
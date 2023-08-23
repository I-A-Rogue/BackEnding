package net.weg.wegproject.ConcreteClasses.productsClasses.building.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.LanguageAcronyms;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Building extends Product{

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

}
package net.weg.wegproject.ConcreteClasses.productsClasses.automation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.enums.InputPhases;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Automation extends Product {

    @Column(nullable = false)
    private Integer nominalVoltageInput; //(Volts (V))
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InputPhases numberPhasesEntry; //(Ex.:Trifásico)
    @Column(nullable = false)
    private String settings; //(Ex.: Com opcionais)
    @Column(nullable = false)
    private Integer nominalChain; //(Ampere (A))
    @Column(nullable = false)
    private Integer nominalChainH; //(Ampere (A)??)
    @Column(nullable = false)
    private String filterRFI; //(ex.: Com filtro (cat C3))
    @Column(nullable = false)
    private String degreeProtection; //(ex.: IP20)
    @Column(nullable = false)
    private String rheostaticBraking; //(ex.: Standard sem frenagem)
    @Column(nullable = false)
    private Boolean inductorLink; //(Sim ou Não)
    @Column(nullable = false)
    private Float temperature; //(Celsius(Cº))
    @Column(nullable = false)
    private Boolean safetyStop; //(Sim ou Não)
    @Column(nullable = false)
    private String electronicFeed; //(Interna, externa ou sem)


    @Override
    public String toString() {
        return "Automation{" +
                "nominalVoltageInput=" + nominalVoltageInput +
                ", numberPhasesEntry=" + numberPhasesEntry +
                ", settings='" + settings + '\'' +
                ", nominalChain=" + nominalChain +
                ", nominalChainH=" + nominalChainH +
                ", filterRFI='" + filterRFI + '\'' +
                ", degreeProtection='" + degreeProtection + '\'' +
                ", rheostaticBraking='" + rheostaticBraking + '\'' +
                ", inductorLink=" + inductorLink +
                ", temperature=" + temperature +
                ", safetyStop=" + safetyStop +
                ", electronicFeed='" + electronicFeed + '\'' +
                '}';
    }
}

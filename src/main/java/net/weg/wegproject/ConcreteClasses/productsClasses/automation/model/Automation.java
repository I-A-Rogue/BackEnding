package net.weg.wegproject.ConcreteClasses.productsClasses.automation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    Integer nominalVoltageInput; //(Volts (V))
    @Enumerated(EnumType.STRING)
    InputPhases numberPhasesEntry; //(Ex.:Trifásico)
    String settings; //(Ex.: Com opcionais)
    Integer nominalChain; //(Ampere (A))
    Integer nominalChainH; //(Ampere (A)??)
    String filterRFI; //(ex.: Com filtro (cat C3))
    String degreeProtection; //(ex.: IP20)
    String rheostaticBraking; //(ex.: Standard sem frenagem)
    Boolean inductorLink; //(Sim ou Não)
    Float temperature; //(Celsius(Cº))
    Boolean safetyStop; //(Sim ou Não)
    String electronicFeed; //(Interna, externa ou sem)

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo")
    @JsonIgnore
    private Product produto;

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
//                "Product{" +
//                ", code=" + produto.getCode() +
//                ", name='" + produto.getName() + '\'' +
//                ", price=" + produto.getPrice() +
//                ", stockSize=" + produto.getStockSize() +
//                ", description='" + produto.getDescription() + '\'' +
//                ", categories=" + produto.getCategories() +
//                ", assessment=" + produto.getAssessment() +
                '}';
    }

}

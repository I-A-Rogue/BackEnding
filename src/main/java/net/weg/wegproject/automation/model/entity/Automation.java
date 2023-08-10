package net.weg.wegproject.automation.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.categories.model.entity.Categories;
import net.weg.wegproject.enums.InputPhases;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Automation")

public class Automation extends Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer nominalVoltageInput; //(Volts (V))

//    @Enumerated(EnumType.STRING)
//    InputPhases numberPhasesEntry; //(Ex.:Trifásico)
//    String settings; //(Ex.: Com opcionais)
//    Integer nominalChain; //(Ampere (A))
//    Integer nominalChainH; //(Ampere (A)??)
//    String filterRFI; //(ex.: Com filtro (cat C3))
//    String degreeProtection; //(ex.: IP20)
//    String rheostaticBraking; //(ex.: Standard sem frenagem)
//    boolean inductorLink; //(Sim ou Não)
//    float temperature; //(Celsius(Cº))
//    boolean safetyStop; //(Sim ou Não)
//    String electronicFeed; //(Interna, externa ou sem)

}

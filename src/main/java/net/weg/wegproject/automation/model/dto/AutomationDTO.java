package net.weg.wegproject.automation.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.InputPhases;
import net.weg.wegproject.product.model.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AutomationDTO extends Product {

    @NotNull
    Integer nominalVoltageInput;

    @NotNull
    @Enumerated(EnumType.STRING)
    InputPhases numberPhasesEntry;

    @NotNull
    String settings;

    @NotNull
    Integer nominalChain;

    @NotNull
    Integer nominalChainH;

    @NotNull
    String filterRFI;

    @NotNull
    String degreeProtection;

    @NotNull
    String rheostaticBraking;

    boolean inductorLink;

    @NotNull
    float temperature;

    @NotNull
    boolean safetyStop;

    @NotNull
    String electronicFeed;
}

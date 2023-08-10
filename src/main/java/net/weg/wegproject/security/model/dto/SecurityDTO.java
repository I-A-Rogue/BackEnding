package net.weg.wegproject.security.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.entity.Product;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SecurityDTO extends Product {
    @NotNull
    Integer voltageNominalIsolationUi; //(Volts (V))
    @NotNull
    Integer limitMinimumFrequency; //(Hertz (Hz))
    @NotNull
    Integer limitMaximumFrequency; //(Hertz (Hz))
    @NotNull
    Integer mechanics; //(Milhões)
    @NotNull
    Integer mechanicalLife; //(Milhões)
    @NotNull
    String EletricalLife;
    @NotNull
    String degreeProtecaoTerminals;
    @NotNull
    String grauProtecaoBobina;
    @NotNull
    Integer degreeProtectionCoil; //(Ampere (A))
    @NotNull
    String currentNominalIn;
    @NotNull
    String currentNominalEmployment;
    @NotNull
    Integer voltageEmploymentUIEC; //(Volts (V))
    @NotNull
    Integer voltageEmploymentUIUE; //(Volts (V))
    @NotNull
    float height; //(Milímetros (mm))
    @NotNull
    float Width; //(Milímetros (mm))
    @NotNull
    float Depth; //(Milímetros (mm))
    @NotNull
    float grossWeight; //(Milímetros (kg))
    @NotNull
    String Reference;
    @NotNull
    String contact;
    @NotNull
    Integer voltageCommand; //(Volts (V))
    @NotNull
    String terminalType;
}
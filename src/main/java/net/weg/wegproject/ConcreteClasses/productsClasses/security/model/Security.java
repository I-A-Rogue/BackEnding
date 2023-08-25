package net.weg.wegproject.ConcreteClasses.productsClasses.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Security extends Product {

    @Column(nullable = false)
    private Integer voltageNominalIsolationUi; //(Volts (V))

    @Column(nullable = false)
    private Integer limitMinimumFrequency; //(Hertz (Hz))

    @Column(nullable = false)
    private Integer limitMaximumFrequency; //(Hertz (Hz))

    @Column(nullable = false)
    private Integer mechanics; //(Milhões)

    @Column(nullable = false)
    private Integer mechanicalLife; //(Milhões)

    @Column(nullable = false)
    private String EletricalLife;

    @Column(nullable = false)
    private String degreeProtecaoTerminals;

    @Column(nullable = false)
    private String grauProtecaoBobina;

    @Column(nullable = false)
    private Integer degreeProtectionCoil; //(Ampere (A))

    @Column(nullable = false)
    private String currentNominalIn;

    @Column(nullable = false)
    private String currentNominalEmployment;

    @Column(nullable = false)
    private Integer voltageEmploymentUIEC; //(Volts (V))

    @Column(nullable = false)
    private Integer voltageEmploymentUIUE; //(Volts (V))

    @Column(nullable = false)
    private Float height; //(Milímetros (mm))

    @Column(nullable = false)
    private Float Width; //(Milímetros (mm))

    @Column(nullable = false)
    private Float Depth; //(Milímetros (mm))

    @Column(nullable = false)
    private Float grossWeight; //(Milímetros (kg))

    @Column(nullable = false)
    private String Reference;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private Integer voltageCommand; //(Volts (V))

    @Column(nullable = false)
    private String terminalType;

    @OneToOne
    @JsonIgnore
    private Product product_security;

    @Override
    public String toString() {
        return "Security{" +
                "voltageNominalIsolationUi=" + voltageNominalIsolationUi +
                ", limitMinimumFrequency=" + limitMinimumFrequency +
                ", limitMaximumFrequency=" + limitMaximumFrequency +
                ", mechanics=" + mechanics +
                ", mechanicalLife=" + mechanicalLife +
                ", EletricalLife='" + EletricalLife + '\'' +
                ", degreeProtecaoTerminals='" + degreeProtecaoTerminals + '\'' +
                ", grauProtecaoBobina='" + grauProtecaoBobina + '\'' +
                ", degreeProtectionCoil=" + degreeProtectionCoil +
                ", currentNominalIn='" + currentNominalIn + '\'' +
                ", currentNominalEmployment='" + currentNominalEmployment + '\'' +
                ", voltageEmploymentUIEC=" + voltageEmploymentUIEC +
                ", voltageEmploymentUIUE=" + voltageEmploymentUIUE +
                ", height=" + height +
                ", Width=" + Width +
                ", Depth=" + Depth +
                ", grossWeight=" + grossWeight +
                ", Reference='" + Reference + '\'' +
                ", contact='" + contact + '\'' +
                ", voltageCommand=" + voltageCommand +
                ", terminalType='" + terminalType + '\'' +
                '}';
    }
}
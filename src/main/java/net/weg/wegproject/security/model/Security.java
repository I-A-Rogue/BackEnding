package net.weg.wegproject.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.beans.BeanUtils;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Security")

public class Security extends Product {

    @Column(nullable = false)
    Integer voltageNominalIsolationUi; //(Volts (V))

    @Column(nullable = false)
    Integer limitMinimumFrequency; //(Hertz (Hz))

    @Column(nullable = false)
    Integer limitMaximumFrequency; //(Hertz (Hz))

    @Column(nullable = false)
    Integer mechanics; //(Milhões)

    @Column(nullable = false)
    Integer mechanicalLife; //(Milhões)

    @Column(nullable = false)
    String EletricalLife;

    @Column(nullable = false)
    String degreeProtecaoTerminals;

    @Column(nullable = false)
    String grauProtecaoBobina;

    @Column(nullable = false)
    Integer degreeProtectionCoil; //(Ampere (A))

    @Column(nullable = false)
    String currentNominalIn;

    @Column(nullable = false)
    String currentNominalEmployment;

    @Column(nullable = false)
    Integer voltageEmploymentUIEC; //(Volts (V))

    @Column(nullable = false)
    Integer voltageEmploymentUIUE; //(Volts (V))

    @Column(nullable = false)
    float height; //(Milímetros (mm))

    @Column(nullable = false)
    float Width; //(Milímetros (mm))

    @Column(nullable = false)
    float Depth; //(Milímetros (mm))

    @Column(nullable = false)
    float grossWeight; //(Milímetros (kg))

    @Column(nullable = false)
    String Reference;

    @Column(nullable = false)
    String contact;

    @Column(nullable = false)
    Integer voltageCommand; //(Volts (V))

    @Column(nullable = false)
    String terminalType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo")
    private Product produto;
}
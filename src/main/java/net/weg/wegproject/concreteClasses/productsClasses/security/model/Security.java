package net.weg.wegproject.concreteClasses.productsClasses.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/security/model/Security.java
import net.weg.wegproject.product.model.entity.Product;
=======
import net.weg.wegproject.concreteClasses.productsClasses.product.model.entity.Product;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/productsClasses/security/model/Security.java

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Security")

public class Security extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code")
    Product product_code;
}
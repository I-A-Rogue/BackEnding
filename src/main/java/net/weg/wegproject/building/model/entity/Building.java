package net.weg.wegproject.building.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.enums.LanguageAcronyms;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.beans.BeanUtils;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Building")

public class Building extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String referenceProduct;

    @Column(nullable = false)
    String codigoInteligente;

    @Column(nullable = false)
    Integer ratedPower; //(Volt-Ampère (VA))

    @Column(nullable = false)
    String voltageInput; //(Volts (V))

    @Column(nullable = false)
    Integer voltageOutput; //(Volts (V))

    @Column(nullable = false)
    Integer autonomy; //(Minutos (Min))

    @Column(nullable = false)
    String batterytype;

    @Column(nullable = false)
    Integer frequency; //(Hertz (Hz))

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    LanguageAcronyms language; //(sigla PT-Br..)

    @Column(nullable = false)
    float nominalChain; //(Ampere (A))

    @Column(nullable = false)
    Integer busVoltage; //(Tensão Corrente Contínua (VCC))

    @Column(nullable = false)
    Integer currentBatteries; //(Ampère-hora (Ah))

    @Column(nullable = false)
    String typeplug;

    @Column(nullable = false)
    String casing;

    @Column(nullable = false)
    String colorStructure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo")
    private Product produto;
}
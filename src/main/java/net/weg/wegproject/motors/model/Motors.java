package net.weg.wegproject.motors.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.product.model.entity.Product;
import net.weg.wegproject.enums.IsolationClass;
import org.springframework.beans.BeanUtils;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Motors")

public class Motors extends Product {

    @Column(nullable = false)
    String carcass;

    @Column(nullable = false)
    String materialCarcass;

    @Column(nullable = false)
    float power; //(Quilowatt (Kw))

    @Column(nullable = false)
    Integer frequency; //(hertz(Hz))

    @Column(nullable = false)
    float performance; //(baseado em 100% carga)

    @Column(nullable = false)
    float powerFactor; //(baseado em 100% carga)

    @Column(nullable = false)
    Integer nominalRotation; //(Rotation per minute (Rpm))

    @Column(nullable = false)
    float slip; //(Porcentagem (%))

    @Column(nullable = false)
    float ratedVoltage; //(Volts  (V))

    @Column(nullable = false)
    float nominalChain; //(Ampere (A))

    @Column(nullable = false)
    float currentDeparture; //(Ampere (A))

    @Column(nullable = false)
    float ipIn; //(Tempo de partida)

    @Column(nullable = false)
    float currentEmpty; //(Ampere (A))

    @Column(nullable = false)
    float conjugateNominal; //(quilograma-força-metro (kgfm))

    @Column(nullable = false)
    float conjugateDeparture; //(Porcentagem (%))

    @Column(nullable = false)
    float maximumConjugate; //(Porcentagem (%))

    @Column(nullable = false)
    String timeRotorLocked; //(Segundo (s))

    @Column(nullable = false)
    float momentInertia; //(Quilogrâmetro (kgm))

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    IsolationClass classIsolation; //(B (130 C), F (155 C) ou H (180 C))

    @Column(nullable = false)
    String regimeService; //(ex.: Cont.(S1))

    @Column(nullable = false)
    boolean matchMethod; //(Direta ou indireta)

    @Column(nullable = false)
    float roomTemperature; //(Graus celsius)

    @Column(nullable = false)
    Integer altitude; //(Metros (mt))

    @Column(nullable = false)
    String degreeProtection; //(ex.: IP21)

    @Column(nullable = false)
    String refrigeration; //(ex.: IC01 - ODP)

    @Column(nullable = false)
    String ConstructiveWay; //(ex.: F-1/B34R(D))

    @Column(nullable = false)
    boolean rotationDirection; //(horário ou anti-horário ¹)

    @Column(nullable = false)
    float approximateMass; //(Quilogramas cúbicas (kg))

    @Column(nullable = false)
    String impregnationMethod; //(ex.: Imersão poliéster)

    @Column(nullable = false)
    String materialAxis; //(ex.: Aço carbono SAE 1040/45)

    @Column(nullable = false)
    String painting; //(ex.: Munsell N 1 - fosco 207N)

    @Column(nullable = false)
    String typeGrounding; //(ex.: Único)

    @Column(nullable = false)
    String materialBaffleCover;

    @Column(nullable = false)
    String thermalProtectionWinding;

    @Column(nullable = false)
    String bearingType; //(ex.:6203 2RS)

    @Column(nullable = false)
    String bearingLNA; //(ex.:6202 ZZ)

    @Column(nullable = false)
    String protectorFenolicOverload;

    @Column(nullable = false)
    String tropicalizedPainting;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_codigo")
    @JsonIgnore
    private Product produto;

    @Override
    public String toString() {
        return "Motors{" +
                "carcass='" + carcass + '\'' +
                ", materialCarcass='" + materialCarcass + '\'' +
                ", power=" + power +
                ", frequency=" + frequency +
                ", performance=" + performance +
                ", powerFactor=" + powerFactor +
                ", nominalRotation=" + nominalRotation +
                ", slip=" + slip +
                ", ratedVoltage=" + ratedVoltage +
                ", nominalChain=" + nominalChain +
                ", currentDeparture=" + currentDeparture +
                ", ipIn=" + ipIn +
                ", currentEmpty=" + currentEmpty +
                ", conjugateNominal=" + conjugateNominal +
                ", conjugateDeparture=" + conjugateDeparture +
                ", maximumConjugate=" + maximumConjugate +
                ", timeRotorLocked='" + timeRotorLocked + '\'' +
                ", momentInertia=" + momentInertia +
                ", classIsolation=" + classIsolation +
                ", regimeService='" + regimeService + '\'' +
                ", matchMethod=" + matchMethod +
                ", roomTemperature=" + roomTemperature +
                ", altitude=" + altitude +
                ", degreeProtection='" + degreeProtection + '\'' +
                ", refrigeration='" + refrigeration + '\'' +
                ", ConstructiveWay='" + ConstructiveWay + '\'' +
                ", rotationDirection=" + rotationDirection +
                ", approximateMass=" + approximateMass +
                ", impregnationMethod='" + impregnationMethod + '\'' +
                ", materialAxis='" + materialAxis + '\'' +
                ", painting='" + painting + '\'' +
                ", typeGrounding='" + typeGrounding + '\'' +
                ", materialBaffleCover='" + materialBaffleCover + '\'' +
                ", thermalProtectionWinding='" + thermalProtectionWinding + '\'' +
                ", bearingType='" + bearingType + '\'' +
                ", bearingLNA='" + bearingLNA + '\'' +
                ", protectorFenolicOverload='" + protectorFenolicOverload + '\'' +
                ", tropicalizedPainting='" + tropicalizedPainting + '\'' +
                "Product{" +
                ", code=" + produto.getCode() +
                ", name='" + produto.getName() + '\'' +
                ", price=" + produto.getPrice() +
                ", stockSize=" + produto.getStockSize() +
                ", description='" + produto.getDescription() + '\'' +
                ", categories=" + produto.getCategories() +
                ", assessment=" + produto.getAssessment() +
                '}';
    }
}
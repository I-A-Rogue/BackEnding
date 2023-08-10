package net.weg.wegproject.motors.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.IsolationClass;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MotorsDTO {
    @NotNull
    String carcass;
    @NotNull
    String materialCarcass;
    @NotNull
    float power; //(Quilowatt (Kw))
    @NotNull
    Integer frequency; //(hertz(Hz))
    @NotNull
    float performance; //(baseado em 100% carga)
    @NotNull
    float powerFactor; //(baseado em 100% carga)
    @NotNull
    Integer nominalRotation; //(Rotation per minute (Rpm))
    @NotNull
    float slip; //(Porcentagem (%))
    @NotNull
    float ratedVoltage; //(Volts  (V))
    @NotNull
    float nominalChain; //(Ampere (A))
    @NotNull
    float currentDeparture; //(Ampere (A))
    @NotNull
    float ipIn; //(Tempo de partida)
    @NotNull
    float currentEmpty; //(Ampere (A))
    @NotNull
    float conjugateNominal; //(quilograma-força-metro (kgfm))
    @NotNull
    float conjugateDeparture; //(Porcentagem (%))
    @NotNull
    float maximumConjugate; //(Porcentagem (%))
    @NotNull
    String timeRotorLocked; //(Segundo (s))
    @NotNull
    float momentInertia; //(Quilogrâmetro (kgm))
    @NotNull
    @Enumerated(EnumType.STRING)
    IsolationClass classIsolation; //(B (130 C), F (155 C) ou H (180 C))
    @NotNull
    String regimeService; //(ex.: Cont.(S1))
    @NotNull
    boolean matchMethod; //(Direta ou indireta)
    @NotNull
    float roomTemperature; //(Graus celsius)
    @NotNull
    Integer altitude; //(Metros (mt))
    @NotNull
    String degreeProtection; //(ex.: IP21)
    @NotNull
    String refrigeration; //(ex.: IC01 - ODP)
    @NotNull
    String ConstructiveWay; //(ex.: F-1/B34R(D))
    @NotNull
    boolean rotationDirection; //(horário ou anti-horário ¹)
    @NotNull
    float approximateMass; //(Quilogramas cúbicas (kg))
    @NotNull
    String impregnationMethod; //(ex.: Imersão poliéster)
    @NotNull
    String materialAxis; //(ex.: Aço carbono SAE 1040/45)
    @NotNull
    String painting; //(ex.: Munsell N 1 - fosco 207N)
    @NotNull
    String typeGrounding; //(ex.: Único)
    @NotNull
    String materialBaffleCover;
    @NotNull
    String thermalProtectionWinding;
    @NotNull
    String bearingType; //(ex.:6203 2RS)
    @NotNull
    String bearingLNA; //(ex.:6202 ZZ)
    @NotNull
    String protectorFenolicOverload;
    @NotNull
    String tropicalizedPainting;
}
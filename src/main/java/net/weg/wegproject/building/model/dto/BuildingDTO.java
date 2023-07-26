package net.weg.wegproject.building.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.LanguageAcronyms;

@AllArgsConstructor
@NoArgsConstructor

public class BuildingDTO extends ProductDTO {

    @NotNull
    String referenciaProduto;
    @NotNull
    String codigoInteligente;
    @NotNull
    Integer potenciaNominal;
    @NotNull
    String tensaoEntrada;
    @NotNull
    Integer tensaoSaida;
    @NotNull
    Integer autonomia;
    @NotNull
    String tipoBateria;
    @NotNull
    Integer frequencia;
    @NotNull
    @Enumerated(EnumType.STRING)
    LanguageAcronyms idioma;
    @NotNull
    float correnteNominal;
    @NotNull
    Integer tensaoBarramento;
    @NotNull
    Integer correnteBaterias;
    @NotNull
    String tipoTomada;
    @NotNull
    String involucro;
    @NotNull
    String corEstrutura;

}
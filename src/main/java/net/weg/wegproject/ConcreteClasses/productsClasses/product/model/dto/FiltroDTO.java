package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.enums.InkEnums;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FiltroDTO {

    private Float priceMin;
    private Float priceMax;
    private InkEnums type;
    private Integer density;
    private String color;
    private Boolean assesment;
    private Integer power;
    private String material;
    private String  carcass;
    private Float voltage;
    private String rfi;
    private Float temperature;
    private Float voltageMin;
    private Float voltageMax;
    private Float frequencyMin;
    private Float frequencyMax;
    private String plug;
    private String battery;
    private String casing;
}
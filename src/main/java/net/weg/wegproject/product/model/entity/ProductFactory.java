package net.weg.wegproject.product.model.entity;

import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.enums.InkEnums;
import net.weg.wegproject.enums.InputPhases;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.security.model.Security;
import org.modelmapper.ModelMapper;

import java.util.Map;

public class ProductFactory {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Product criarProduto(ProductDTO productDTO) {
        switch (productDTO.getCategories().name()) {
            case "MOTOR" -> {
                Motors motors = new Motors();
                Object object = productDTO.getObject();
                modelMapper.map(object, motors);
                return motors;
            }
            case "AUTOMACAO"->{
                Automation automation = new Automation();
                Object object = productDTO.getObject();
                modelMapper.map(object, automation);
                return automation;
            }
            case "BUILDING"->{
                Building building = new Building();
                Object object = productDTO.getObject();
                modelMapper.map(object, building);
                return building;
            }
            case "TINTA"-> {
                Ink ink = new Ink();
                Object object = productDTO.getObject();
                modelMapper.map(object, ink);
                return ink;
            }
            case "SECURITY"->{
                Security security = new Security();
                Object object = productDTO.getObject();
                modelMapper.map(object, security);
                return security;
            }
            default->{
                throw new IllegalArgumentException("Categoria inválida");
            }
        }
    }
}


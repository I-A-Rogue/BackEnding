package net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity;

import net.weg.wegproject.ConcreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;

import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import org.modelmapper.ModelMapper;

public class ProductFactory {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Product criarProduto(ProductDTO productDTO) {
        switch (productDTO.getCategories().name()) {
            case "MOTORS" -> {
                Motors motors = new Motors();
                Object object = productDTO.getObject();
                modelMapper.map(object, motors);
                return motors;
            }
            case "AUTOMATION"->{
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
            case "INK"-> {
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


package net.weg.wegproject.concreteClasses.productsClasses.product.model.entity;

<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/product/model/entity/ProductFactory.java
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.security.model.Security;

import static net.weg.wegproject.categories.enuns.CategoriesEnums.*;


public class ProductFactory {
    public static Product createProduct(Product product){
        if(product.getCategories().equals(TINTA)){
            Ink ink = product.getInk();
            ink.setProduct_code(product);
            return ink;
        }else if(product.getCategories().equals(MOTOR)){
            Motors motors = product.getMotors();
            motors.setProduct_code(product);
            return motors;
        }else if(product.getCategories().equals(AUTOMACAO)){
            Automation automation = product.getAutomation();
            automation.setProduct_code(product);
            return automation;
        }else if(product.getCategories().equals(SEGURANCA)){
            Security security = product.getSecurity();
            security.setProduct_code(product);
            return security;
        }else if(product.getCategories().equals(BUILDING)){
            Building building = product.getBuilding();
            building.setProduct_code(product);
            return building;
        }else {
            return null;
        }
    }
}

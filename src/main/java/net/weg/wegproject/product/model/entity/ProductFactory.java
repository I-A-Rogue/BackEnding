package net.weg.wegproject.product.model.entity;

import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.security.model.Security;

public class ProductFactory {
    public static Product createProduct(String type){
        switch (type){
            case "Tinta":
                return new Ink();
            case "Motor":
                return new Motors();
            case "Automação":
                return new Automation();
            case "Segurança":
                return new Security();
            case "Building":
                return new Building();
            default:
                return null;
        }
    }
}

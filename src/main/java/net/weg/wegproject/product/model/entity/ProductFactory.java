package net.weg.wegproject.product.model.entity;

import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.building.model.entity.Building;
import net.weg.wegproject.enums.InkEnums;
import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.ink.model.InkDTO;
import net.weg.wegproject.motors.model.Motors;
import net.weg.wegproject.motors.model.MotorsDTO;
import net.weg.wegproject.motors.service.MotorsService;
import net.weg.wegproject.product.model.dto.ProductDTO;
import net.weg.wegproject.security.model.Security;
import org.springframework.beans.BeanUtils;

import java.util.Map;

import static net.weg.wegproject.categories.enuns.CategoriesEnums.TINTA;

public class ProductFactory {

    public static Product criarProduto(ProductDTO productDTO) {
        System.out.println(productDTO.getCategories());
        switch (productDTO.getCategories().name()) {
            case "MOTOR" -> {
                return new Motors();
            }
            case "AUTOMATION"->{
                return new Automation();
            }
            case "BUILDING"->{
                return new Building();
            }
            case "TINTA"-> {
                Ink ink = new Ink();
                Object object = productDTO.getObject();
                Map<String, Object> data = (Map<String, Object>) object;
                ink.setColor((String) data.get("color"));
                ink.setDensity((String) data.get("density"));
                ink.setType(InkEnums.PO);
                return ink;
            }
            case "SECURITY"->{
                return new Security();
            }
            default->{
                throw new IllegalArgumentException("Categoria inválida");
            }
        }
    }
}


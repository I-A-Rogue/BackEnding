package net.weg.wegproject.ConcreteClasses.productsClasses.building.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.repository.BuildingRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuildingService{

    BuildingRepository buildingRepository;

    public Building findOne(Long id) {
        return buildingRepository.findById(id).orElseThrow();
    }

    public Building update(Building obj) {
        return buildingRepository.save(obj);
    }
}

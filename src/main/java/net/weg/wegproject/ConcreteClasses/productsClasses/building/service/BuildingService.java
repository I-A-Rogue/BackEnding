package net.weg.wegproject.ConcreteClasses.productsClasses.building.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.repository.BuildingRepository;
import net.weg.wegproject.interfaces.ServiceProductInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuildingService implements ServiceProductInterface<Building> {
    BuildingRepository buildingRepository;

    @Override
    public Building create(Building obj) {
        return buildingRepository.save(obj);
    }
}

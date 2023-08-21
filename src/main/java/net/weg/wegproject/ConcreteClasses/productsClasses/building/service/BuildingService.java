package net.weg.wegproject.ConcreteClasses.productsClasses.building.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.repository.BuildingRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BuildingService implements ServiceInterface<Building> {
    BuildingRepository buildingRepository;


    @Override
    public Building create(Building obj) {
        return buildingRepository.save(obj);
    }

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building findOne(Long id) {
        try {
            return buildingRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Prédio inexistente");
        }
    }

    @Override
    public Building update(Building obj) {
        return buildingRepository.save(obj);
    }

    @Override
    public Building delete(Long id) {
        Building building = findOne(id);
        buildingRepository.deleteById(id);
        return building;
    }
}

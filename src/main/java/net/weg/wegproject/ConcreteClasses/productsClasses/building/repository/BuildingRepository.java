package net.weg.wegproject.ConcreteClasses.productsClasses.building.repository;

import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}

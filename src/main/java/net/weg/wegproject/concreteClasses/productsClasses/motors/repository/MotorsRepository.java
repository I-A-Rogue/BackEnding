package net.weg.wegproject.concreteClasses.productsClasses.motors.repository;

import net.weg.wegproject.concreteClasses.productsClasses.motors.model.Motors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorsRepository extends JpaRepository<Motors, Long> {
}

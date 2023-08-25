package net.weg.wegproject.ConcreteClasses.productsClasses.motors.repository;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorsRepository extends JpaRepository<Motors, Long> {
}

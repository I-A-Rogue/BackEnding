package net.weg.wegproject.concreteClasses.productsClasses.automation.repository;

import net.weg.wegproject.concreteClasses.productsClasses.automation.model.Automation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationRepository extends JpaRepository<Automation, Long> {
}

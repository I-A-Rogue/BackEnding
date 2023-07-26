package net.weg.wegproject.automation.repository;

import net.weg.wegproject.automation.model.entity.Automation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationRepository extends JpaRepository<Automation, Long> {
}

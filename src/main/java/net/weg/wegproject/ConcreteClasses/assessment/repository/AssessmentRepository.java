package net.weg.wegproject.ConcreteClasses.assessment.repository;

import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}

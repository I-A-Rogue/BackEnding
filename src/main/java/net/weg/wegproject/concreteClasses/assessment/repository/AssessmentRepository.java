package net.weg.wegproject.concreteClasses.assessment.repository;

<<<<<<< Updated upstream:src/main/java/net/weg/wegproject/assessment/repository/AssessmentRepository.java
import net.weg.wegproject.assessment.model.entity.Assessment;
import org.springframework.data.domain.Page;
=======
import net.weg.wegproject.concreteClasses.assessment.model.entity.Assessment;
>>>>>>> Stashed changes:src/main/java/net/weg/wegproject/concreteClasses/assessment/repository/AssessmentRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}

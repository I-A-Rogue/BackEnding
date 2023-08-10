package net.weg.wegproject.assessment.repository;

import net.weg.wegproject.assessment.model.entity.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}

package net.weg.wegproject.concreteClasses.assessment.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.concreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.concreteClasses.assessment.repository.AssessmentRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class AssessmentService implements ServiceInterface<Assessment> {
    AssessmentRepository assessmentRepository;

    @Override
    public Assessment create(Assessment obj) {
        return assessmentRepository.save(obj);
    }

    @Override
    public List<Assessment> findAll() {
        return assessmentRepository.findAll();
    }

    @Override
    public Assessment findOne(Long id) {
        try {
            return assessmentRepository.findById(id).orElseThrow();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Avaliação inexistente");
        }
    }

    @Override
    public Assessment update(Assessment obj) {
        return assessmentRepository.save(obj);
    }

    @Override
    public Assessment delete(Long id) {
        Assessment assessment = findOne(id);
        assessmentRepository.deleteById(id);
        return assessment;
    }
}

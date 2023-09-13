package net.weg.wegproject.ConcreteClasses.assessment.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.exceptions.*;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.assessment.repository.AssessmentRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AssessmentService implements ServiceInterface<Assessment> {
    AssessmentRepository assessmentRepository;

    @Override
    public Assessment create(Assessment obj) {
        try {
            return assessmentRepository.save(obj);
        }catch (Exception e){
            throw new AssessmentCreateException();
        }
    }

    @Override
    public List<Assessment> findAll() {
        try {
            return assessmentRepository.findAll();
        } catch (Exception e) {
            throw new NoAssessmentsException();
        }
    }

    @Override
    public Assessment findOne(Long id) {
        try {
            return assessmentRepository.findById(id).orElseThrow();
        }catch (Exception e){
            throw new NoAssessmentException();
        }
    }

    @Override
    public Assessment update(Assessment obj) {
        try {
            return assessmentRepository.save(obj);
        }catch (Exception e){
            throw new AssessmentUpdateException();
        }
    }

    @Override
    public Assessment delete(Long id) {
        try {
            Assessment assessment = findOne(id);
            assessmentRepository.deleteById(id);
            return assessment;
        }catch (Exception e){
            throw new AssessmentDeleteException();
        }
    }
}

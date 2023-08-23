package net.weg.wegproject.ConcreteClasses.assessment.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.assessment.exceptions.*;
import net.weg.wegproject.ConcreteClasses.assessment.model.dto.AssessmentDTO;
import net.weg.wegproject.ConcreteClasses.assessment.model.entity.Assessment;
import net.weg.wegproject.ConcreteClasses.assessment.service.AssessmentService;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/assessment")
public class AssessmentController {
    AssessmentService assessmentService;

    @PutMapping("add/{assessmentId}")
    public ResponseEntity<Assessment> addAssessment(@PathVariable Long assessmentId, @RequestBody AssessmentDTO objDTO){
        try {
            try {
                Assessment assessment = assessmentService.findOne(assessmentId);
                assessment.setAmountVotes(assessment.getAmountVotes() + 1);
                assessment.setAssessment(assessment.getAssessment() + objDTO.getAssessment());
                assessment.setTotalAssessment(assessment.getAmountVotes() / assessment.getAssessment());
                return ResponseEntity.ok(assessmentService.update(assessment));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new AssessmentCreateException();
        }
    }

    @GetMapping
    public ResponseEntity<List<Assessment>> findAll() {
        try {
            return ResponseEntity.ok(assessmentService.findAll());
        } catch (Exception e) {
            throw new NoAssessmentsException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(assessmentService.findOne(id));
        } catch (Exception e) {
            throw new NoAssessmentException();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Assessment> update(@PathVariable Long id, @RequestBody AssessmentDTO objDTO) {
        try {
            try {
                Assessment assessment = assessmentService.findOne(id);
                BeanUtils.copyProperties(objDTO, assessment);
                return ResponseEntity.ok(assessmentService.update(assessment));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new AssessmentUpdateException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Assessment> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(assessmentService.delete(id));
        } catch (Exception e) {
            throw new AssessmentDeleteException();
        }
    }
}

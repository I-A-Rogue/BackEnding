package net.weg.wegproject.automation.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.automation.exceptions.*;
import net.weg.wegproject.automation.model.dto.AutomationDTO;
import net.weg.wegproject.interfeces.ControllerInterface;
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.automation.service.AutomationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/automation")
public class AutomationController implements ControllerInterface<Automation, AutomationDTO> {
    AutomationService automationService;

    @PostMapping
    @Override
    public ResponseEntity<Automation> create(AutomationDTO objDTO) {
        try {

            try {
                Automation automation = new Automation();
                BeanUtils.copyProperties(objDTO, automation);
                return ResponseEntity.ok(automationService.create(automation));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new AutomationCreateException();
        }
    }
    @GetMapping
    @Override
    public ResponseEntity<List<Automation>> findAll() {
        try {
            return ResponseEntity.ok(automationService.findAll());
        } catch (Exception e) {
            throw new NoAutomationsException();
        }
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Automation> findOne(Long id) {
        try {
            return ResponseEntity.ok(automationService.findOne(id));
        } catch (Exception e) {
            throw new NoAutomationException();
        }
    }

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<Automation> update(AutomationDTO objDTO, Long id) {
        try {
            try {
                Automation automation = automationService.findOne(id);
                BeanUtils.copyProperties(objDTO, automation);
                return ResponseEntity.ok(automationService.update(automation));
            } catch (BeansException e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            throw new AutomationUpdateException();
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Automation> delete(Long id) {
        try {
            return ResponseEntity.ok(automationService.delete(id));
        } catch (Exception e) {
            throw new AutomationDeleteException();
        }
    }
}

package net.weg.wegproject.ConcreteClasses.productsClasses.automation.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.repository.AutomationRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutomationService {
    AutomationRepository automationRepository;

    public Automation findOne(Long id) {
        return automationRepository.findById(id).orElseThrow();
    }

    public Automation update(Automation obj) {
        return automationRepository.save(obj);
    }
}

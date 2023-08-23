package net.weg.wegproject.ConcreteClasses.productsClasses.automation.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.repository.AutomationRepository;
import net.weg.wegproject.interfaces.ServiceProductInterface;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AutomationService implements ServiceProductInterface<Automation> {
    AutomationRepository automationRepository;

    @Override
    public Automation create(Automation obj) {
        return automationRepository.save(obj);
    }
}
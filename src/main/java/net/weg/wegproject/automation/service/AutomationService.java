package net.weg.wegproject.automation.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.automation.model.entity.Automation;
import net.weg.wegproject.automation.repository.AutomationRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class AutomationService implements ServiceInterface<Automation> {
    AutomationRepository automationRepository;

    @Override
    public Automation create(Automation obj) {
        return automationRepository.save(obj);
    }

    @Override
    public List<Automation> findAll() {
        return automationRepository.findAll();
    }

    @Override
    public Automation findOne(Long id) {
        try {
            return automationRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Automação inexistente");
        }
    }

    @Override
    public Automation update(Automation obj) {
        return automationRepository.save(obj);
    }

    @Override
    public Automation delete(Long id) {
        Automation automation = findOne(id);
        automationRepository.deleteById(id);
        return automation;
    }
}

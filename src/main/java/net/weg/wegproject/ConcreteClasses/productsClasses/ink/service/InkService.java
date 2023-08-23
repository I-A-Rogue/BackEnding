package net.weg.wegproject.ConcreteClasses.productsClasses.ink.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ink.repository.InkRepository;
import net.weg.wegproject.interfaces.ServiceProductInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InkService implements ServiceProductInterface<Ink> {
    InkRepository inkRepository;

    @Override
    public Ink create(Ink obj) {
        return inkRepository.save(obj);
    }

}
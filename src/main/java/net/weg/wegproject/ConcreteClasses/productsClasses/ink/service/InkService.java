package net.weg.wegproject.ink.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ink.repository.InkRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import net.weg.wegproject.interfeces.ServiceProductInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class InkService implements ServiceProductInterface<Ink> {
    InkRepository inkRepository;

    @Override
    public Ink create(Ink obj) {
        return inkRepository.save(obj);
    }

}

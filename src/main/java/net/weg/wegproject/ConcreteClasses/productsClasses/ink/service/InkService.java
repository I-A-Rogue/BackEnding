package net.weg.wegproject.ink.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ink.repository.InkRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class InkService implements ServiceInterface<Ink> {
    InkRepository inkRepository;

    @Override
    public Ink create(Ink obj) {
        return inkRepository.save(obj);
    }

    @Override
    public List<Ink> findAll() {
        return inkRepository.findAll();
    }

    @Override
    public Ink findOne(Long id) {
        try {
            return inkRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Tinta não encontrada");
        }
    }

    @Override
    public Ink update(Ink obj) {
        return inkRepository.save(obj);
    }

    @Override
    public Ink delete(Long id) {
        Ink ink = this.findOne(id);
        inkRepository.delete(ink);
        return ink;
    }
}

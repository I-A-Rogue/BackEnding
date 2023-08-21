package net.weg.wegproject.ConcreteClasses.productsClasses.motors.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.repository.MotorsRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MotorsService implements ServiceInterface<Motors> {
    MotorsRepository motorsRepository;


    @Override
    public Motors create(Motors obj) {
        return motorsRepository.save(obj);
    }

    @Override
    public List<Motors> findAll() {
        return motorsRepository.findAll();
    }

    @Override
    public Motors findOne(Long id) {
        try {
            return motorsRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Motor inexistente");
        }
    }

    @Override
    public Motors update(Motors obj) {
        return motorsRepository.save(obj);
    }

    @Override
    public Motors delete(Long id) {
        Motors motors = findOne(id);
        motorsRepository.delete(motors);
        return motors;
    }
}

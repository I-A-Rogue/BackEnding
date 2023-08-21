package net.weg.wegproject.concreteClasses.productsClasses.motors.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.concreteClasses.productsClasses.motors.repository.MotorsRepository;
import net.weg.wegproject.concreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.interfaces.ServiceProductInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorsService implements ServiceProductInterface<Motors> {

    MotorsRepository motorsRepository;

    @Override
    public Motors create(Motors obj) {
        return motorsRepository.save(obj);
    }

}

package net.weg.wegproject.ConcreteClasses.productsClasses.motors.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.repository.MotorsRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorsService{

    MotorsRepository motorsRepository;

    public Motors findOne(Long id) {
        return motorsRepository.findById(id).orElseThrow();
    }

    public Motors update(Motors obj) {
        return motorsRepository.save(obj);
    }
}

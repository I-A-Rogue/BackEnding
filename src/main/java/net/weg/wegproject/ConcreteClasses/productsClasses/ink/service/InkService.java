package net.weg.wegproject.ConcreteClasses.productsClasses.ink.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.repository.InkReposity;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InkService {

    InkReposity inkReposity;

    public Ink findOne(Long id) {
        return inkReposity.findById(id).orElseThrow();
    }

    public Ink update(Ink obj) {
        return inkReposity.save(obj);
    }
}

package net.weg.wegproject.ConcreteClasses.productsClasses.security.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.repository.SecurityRepository;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService {

    SecurityRepository securityRepository;

    public Security findOne(Long id) {
        return securityRepository.findById(id).orElseThrow();
    }

    public Security update(Security obj) {
        return securityRepository.save(obj);
    }
}

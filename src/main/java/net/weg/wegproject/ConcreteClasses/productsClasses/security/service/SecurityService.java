package net.weg.wegproject.ConcreteClasses.productsClasses.security.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.repository.SecurityRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import net.weg.wegproject.interfeces.ServiceProductInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SecurityService implements ServiceProductInterface<Security> {
    SecurityRepository securityRepository;

    @Override
    public Security create(Security obj) {
        return securityRepository.save(obj);
    }
}

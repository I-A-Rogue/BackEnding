package net.weg.wegproject.concreteClasses.productsClasses.security.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.concreteClasses.productsClasses.security.repository.SecurityRepository;
import net.weg.wegproject.concreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.interfaces.ServiceProductInterface;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService implements ServiceProductInterface<Security> {

    SecurityRepository securityRepository;

    @Override
    public Security create(Security obj) {
        return securityRepository.save(obj);
    }
}

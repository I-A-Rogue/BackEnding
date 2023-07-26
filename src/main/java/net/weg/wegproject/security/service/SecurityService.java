package net.weg.wegproject.security.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.security.model.Security;
import net.weg.wegproject.security.repository.SecurityRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SecurityService implements ServiceInterface<Security> {
    SecurityRepository securityRepository;

    @Override
    public Security create(Security obj) {
        return securityRepository.save(obj);
    }

    @Override
    public List<Security> findAll() {
        return securityRepository.findAll();
    }

    @Override
    public Security findOne(Long id) {
        try {
            return securityRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Avaliação inexistente");
        }
    }

    @Override
    public Security update(Security obj) {
        return securityRepository.save(obj);
    }

    @Override
    public Security delete(Long id) {
        Security security = findOne(id);
        securityRepository.delete(security);
        return security;
    }
}

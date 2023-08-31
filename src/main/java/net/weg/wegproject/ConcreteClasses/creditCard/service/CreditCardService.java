package net.weg.wegproject.ConcreteClasses.creditCard.service;



import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.creditCard.exceptions.*;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.ConcreteClasses.creditCard.repository.CreditCardRepository;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.interfaces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditCardService implements ServiceInterface<CreditCard> {
    CreditCardRepository creditCardRepository;
    @Override
    public CreditCard create(CreditCard obj) {
        try {
            return creditCardRepository.save(obj);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<CreditCard> findAll() {
        try {
            return creditCardRepository.findAll();
        }catch (Exception e) {
            throw new NoCreditCardsException();
        }
    }

    @Override
    public CreditCard findOne(Long id) {
        try {
            return creditCardRepository.findById(id).orElseThrow();
        }catch (Exception e){
            throw new NoCreditCardException();
        }
    }

    @Override
    public CreditCard update(CreditCard obj) {
        try {
            return creditCardRepository.save(obj);
        }catch (Exception e) {
            throw new CreditCardUpdateException();
        }
    }

    @Override
    public CreditCard delete(Long id) {
        try {
            CreditCard creditCard = findOne(id);
            creditCardRepository.deleteById(id);
            return creditCard;
        }catch (Exception e){
            throw new CreditCardDeleteException();
        }
    }
}

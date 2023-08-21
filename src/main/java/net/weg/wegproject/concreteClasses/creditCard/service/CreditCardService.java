package net.weg.wegproject.concreteClasses.creditCard.service;

import net.weg.wegproject.concreteClasses.creditCard.exceptions.*;
import net.weg.wegproject.concreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.concreteClasses.creditCard.repository.CreditCardRepository;
import net.weg.wegproject.interfaces.ServiceInterface;

import java.util.List;

public class CreditCardService implements ServiceInterface<CreditCard> {
    CreditCardRepository creditCardRepository;
    @Override
    public CreditCard create(CreditCard obj) {
        try {
            return creditCardRepository.save(obj);
        }catch (Exception e) {
            throw new CreditCardCreateException();
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

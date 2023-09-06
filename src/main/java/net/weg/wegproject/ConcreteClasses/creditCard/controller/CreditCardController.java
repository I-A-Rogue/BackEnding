package net.weg.wegproject.ConcreteClasses.creditCard.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.creditCard.exceptions.CreditCardCreateException;
import net.weg.wegproject.ConcreteClasses.creditCard.exceptions.NoCreditCardException;
import net.weg.wegproject.ConcreteClasses.creditCard.exceptions.NoCreditCardsException;
import net.weg.wegproject.ConcreteClasses.creditCard.model.dto.CreditCardDto;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.ConcreteClasses.creditCard.service.CreditCardService;
import net.weg.wegproject.interfaces.ControllerInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardController {
    CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<CreditCard> create(@RequestBody CreditCardDto objDTO) {
        try {
            CreditCard creditCard = new CreditCard();
            BeanUtils.copyProperties(objDTO, creditCard);
            return ResponseEntity.ok(creditCardService.create(creditCard));
        }catch (Exception e) {
            throw new CreditCardCreateException();
        }
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> findAll() {

        try {
            return ResponseEntity.ok(creditCardService.findAll());
        }catch (Exception e) {
            throw new NoCreditCardsException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> findOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(creditCardService.findOne(id));
        }catch (Exception e) {
            throw new NoCreditCardException();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CreditCard> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(creditCardService.delete(id));
        }catch (Exception e) {
            throw new CreditCardCreateException();
        }
    }
}

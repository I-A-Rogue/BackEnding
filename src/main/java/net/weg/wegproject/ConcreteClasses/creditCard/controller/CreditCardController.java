package net.weg.wegproject.ConcreteClasses.creditCard.controller;

import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.creditCard.model.dto.CreditCardDto;
import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import net.weg.wegproject.ConcreteClasses.creditCard.service.CreditCardService;
import net.weg.wegproject.interfaces.ControllerInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardController implements ControllerInterface<CreditCard, CreditCardDto> {
    CreditCardService creditCardService;
    @Override
    @PostMapping
    public ResponseEntity<CreditCard> create(@RequestBody CreditCardDto objDTO) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(objDTO, creditCard);
        return ResponseEntity.ok(creditCardService.create(creditCard));
    }

    @Override
    public ResponseEntity<List<CreditCard>> findAll() {
        return ResponseEntity.ok(creditCardService.findAll());
    }

    @Override
    public ResponseEntity<CreditCard> findOne(Long id) {
        return ResponseEntity.ok(creditCardService.findOne(id));
    }

    @Override
    public ResponseEntity<CreditCard> update(CreditCardDto objDTO, Long id) {
        CreditCard creditCard = creditCardService.findOne(id);
        BeanUtils.copyProperties(objDTO, creditCard);
        return ResponseEntity.ok(creditCardService.update(creditCard));
    }

    @Override
    public ResponseEntity<CreditCard> delete(Long id) {
        return ResponseEntity.ok(creditCardService.delete(id));
    }
}

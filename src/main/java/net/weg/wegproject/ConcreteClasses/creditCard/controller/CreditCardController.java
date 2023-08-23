package net.weg.wegproject.ConcreteClasses.creditCard.controller;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping("/creditCard")
public class CreditCardController {
    CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<CreditCard> create(@RequestBody CreditCardDto objDTO) {
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(objDTO, creditCard);
        return ResponseEntity.ok(creditCardService.create(creditCard));
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> findAll() {
        return ResponseEntity.ok(creditCardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(creditCardService.findOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CreditCard> delete(@PathVariable Long id) {
        return ResponseEntity.ok(creditCardService.delete(id));
    }
}

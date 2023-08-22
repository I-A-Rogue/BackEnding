package net.weg.wegproject.ConcreteClasses.creditCard.repository;

import net.weg.wegproject.ConcreteClasses.creditCard.model.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

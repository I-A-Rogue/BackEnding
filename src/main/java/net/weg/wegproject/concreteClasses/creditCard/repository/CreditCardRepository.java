package net.weg.wegproject.concreteClasses.creditCard.repository;

import net.weg.wegproject.concreteClasses.creditCard.model.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

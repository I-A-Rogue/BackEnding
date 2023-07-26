package net.weg.wegproject.creditCard.repository;

import net.weg.wegproject.creditCard.model.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

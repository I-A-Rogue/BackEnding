package net.weg.wegproject.ConcreteClasses.creditCard.exceptions;

public class CreditCardCreateException extends RuntimeException{
    public CreditCardCreateException() {
        super("Não foi possivel criar este cartão de crédito");
    }
}

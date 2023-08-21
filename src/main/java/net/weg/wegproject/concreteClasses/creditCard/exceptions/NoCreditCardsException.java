package net.weg.wegproject.concreteClasses.creditCard.exceptions;

public class NoCreditCardsException extends RuntimeException{
    public NoCreditCardsException() {
        super("cartão de crédito inexitente");
    }
}

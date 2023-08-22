package net.weg.wegproject.ConcreteClasses.creditCard.exceptions;

public class NoCreditCardsException extends RuntimeException{
    public NoCreditCardsException() {
        super("cartão de crédito inexitente");
    }
}

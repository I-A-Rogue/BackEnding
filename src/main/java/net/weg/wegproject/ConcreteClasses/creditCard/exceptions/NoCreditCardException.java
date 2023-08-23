package net.weg.wegproject.ConcreteClasses.creditCard.exceptions;

public class NoCreditCardException extends RuntimeException{
    public NoCreditCardException() {
        super("Não exite nenhum cartão de crédito cadastrada");
    }
}

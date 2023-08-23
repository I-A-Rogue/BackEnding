package net.weg.wegproject.ConcreteClasses.creditCard.exceptions;

public class CreditCardUpdateException extends RuntimeException{
    public CreditCardUpdateException() {
        super("Não foi possível editar este cartão de crédito");
    }
}

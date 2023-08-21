package net.weg.wegproject.concreteClasses.creditCard.exceptions;

public class CreditCardDeleteException extends RuntimeException{
    public CreditCardDeleteException() {
        super("Não foi possivel deletar este cartão de crédito");
    }
}

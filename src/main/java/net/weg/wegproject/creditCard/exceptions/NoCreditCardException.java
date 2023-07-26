package net.weg.wegproject.creditCard.exceptions;

public class NoCreditCardException extends RuntimeException{
    public NoCreditCardException() {
        super("Não exite nenhum cartão de crédito cadastrada");
    }
}

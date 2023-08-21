package net.weg.wegproject.concreteClasses.cart.exceptions;

public class NoCartsException extends RuntimeException{
    public NoCartsException() {
        super("Não exite nenhum carrinho cadastrado");
    }
}

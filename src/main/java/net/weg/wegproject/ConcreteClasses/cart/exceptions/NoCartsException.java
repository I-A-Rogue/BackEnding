package net.weg.wegproject.ConcreteClasses.cart.exceptions;

public class NoCartsException extends RuntimeException{
    public NoCartsException() {
        super("Não exite nenhum carrinho cadastrado");
    }
}

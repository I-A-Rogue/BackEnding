package net.weg.wegproject.concreteClasses.cart.exceptions;

public class CartDeleteException extends RuntimeException{
    public CartDeleteException() {
        super("Não foi possivel deletar este carrinho");
    }
}

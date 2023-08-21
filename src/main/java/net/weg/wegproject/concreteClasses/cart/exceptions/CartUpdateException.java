package net.weg.wegproject.concreteClasses.cart.exceptions;

public class CartUpdateException extends RuntimeException{
    public CartUpdateException() {
        super("Não foi possível editar este carrinho");
    }
}

package net.weg.wegproject.cart.exceptions;

public class CartUpdateException extends RuntimeException{
    public CartUpdateException() {
        super("Não foi possível editar este carrinho");
    }
}

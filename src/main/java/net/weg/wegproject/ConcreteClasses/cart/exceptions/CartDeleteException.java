package net.weg.wegproject.cart.exceptions;

public class CartDeleteException extends RuntimeException{
    public CartDeleteException() {
        super("Não foi possivel deletar este carrinho");
    }
}

package net.weg.wegproject.ConcreteClasses.Order.exceptions;

public class NoOrderException extends RuntimeException{
    public NoOrderException() {
        super("Não exite nenhum pedido cadastrado");
    }
}

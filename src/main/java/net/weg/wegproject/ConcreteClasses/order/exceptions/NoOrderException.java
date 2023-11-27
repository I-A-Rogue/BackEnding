package net.weg.wegproject.ConcreteClasses.order.exceptions;

public class NoOrderException extends RuntimeException{
    public NoOrderException() {
        super("Não exite nenhum pedido cadastrado");
    }
}

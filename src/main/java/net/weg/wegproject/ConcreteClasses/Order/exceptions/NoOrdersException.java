package net.weg.wegproject.ConcreteClasses.Order.exceptions;

public class NoOrdersException extends RuntimeException{
    public NoOrdersException() {
        super("Pedido inexitente");
    }
}

package net.weg.wegproject.ConcreteClasses.order.exceptions;

public class NoOrdersException extends RuntimeException{
    public NoOrdersException() {
        super("Pedido inexitente");
    }
}

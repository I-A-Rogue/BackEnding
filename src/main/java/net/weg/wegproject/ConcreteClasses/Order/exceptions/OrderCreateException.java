package net.weg.wegproject.ConcreteClasses.Order.exceptions;

public class OrderCreateException extends RuntimeException{
    public OrderCreateException() {
        super("Não foi possivel criar este pedido");
    }
}

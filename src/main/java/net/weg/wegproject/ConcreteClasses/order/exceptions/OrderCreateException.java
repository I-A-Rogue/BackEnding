package net.weg.wegproject.ConcreteClasses.order.exceptions;

public class OrderCreateException extends RuntimeException{
    public OrderCreateException() {
        super("Não foi possivel criar este pedido");
    }
}

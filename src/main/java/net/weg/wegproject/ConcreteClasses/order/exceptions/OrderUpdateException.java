package net.weg.wegproject.ConcreteClasses.order.exceptions;

public class OrderUpdateException extends RuntimeException{
    public OrderUpdateException() {
        super("Não foi possível editar este pedido");
    }
}

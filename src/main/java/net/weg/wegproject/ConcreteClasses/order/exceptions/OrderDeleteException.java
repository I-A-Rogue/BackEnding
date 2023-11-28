package net.weg.wegproject.ConcreteClasses.order.exceptions;

public class OrderDeleteException extends RuntimeException{
    public OrderDeleteException() {
        super("Não foi possivel deletar este pedido");
    }
}

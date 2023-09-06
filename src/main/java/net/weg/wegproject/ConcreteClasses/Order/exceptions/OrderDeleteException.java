package net.weg.wegproject.ConcreteClasses.Order.exceptions;

public class OrderDeleteException extends RuntimeException{
    public OrderDeleteException() {
        super("Não foi possivel deletar este pedido");
    }
}

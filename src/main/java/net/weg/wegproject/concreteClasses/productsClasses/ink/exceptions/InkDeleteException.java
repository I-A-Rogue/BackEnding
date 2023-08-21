package net.weg.wegproject.concreteClasses.productsClasses.ink.exceptions;

public class InkDeleteException extends RuntimeException{
    public InkDeleteException() {
        super("Não foi possivel deletar esta tinta");
    }
}

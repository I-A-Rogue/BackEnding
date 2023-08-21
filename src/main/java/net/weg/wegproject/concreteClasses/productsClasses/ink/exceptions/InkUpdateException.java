package net.weg.wegproject.concreteClasses.productsClasses.ink.exceptions;

public class InkUpdateException extends RuntimeException{
    public InkUpdateException() {
        super("Não foi possível editar esta tinta");
    }
}

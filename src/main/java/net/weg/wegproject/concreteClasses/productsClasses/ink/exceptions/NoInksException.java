package net.weg.wegproject.concreteClasses.productsClasses.ink.exceptions;

public class NoInksException extends RuntimeException{
    public NoInksException() {
        super("Não exite nenhuma tinta cadastrada");
    }
}

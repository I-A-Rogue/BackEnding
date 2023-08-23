package net.weg.wegproject.ConcreteClasses.saves.exceptions;

public class NoProductsSavedException extends RuntimeException{
    public NoProductsSavedException() {
        super("Nenhum produto salvo");
    }
}

package net.weg.wegproject.concreteClasses.productsClasses.building.exceptions;

public class NoBuildingsException extends RuntimeException{
    public NoBuildingsException() {
        super("Não exite nenhuma building cadastrada");
    }
}

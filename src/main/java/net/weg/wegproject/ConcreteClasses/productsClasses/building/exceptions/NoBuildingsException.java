package net.weg.wegproject.ConcreteClasses.productsClasses.building.exceptions;

public class NoBuildingsException extends RuntimeException{
    public NoBuildingsException() {
        super("Não exite nenhuma building cadastrada");
    }
}

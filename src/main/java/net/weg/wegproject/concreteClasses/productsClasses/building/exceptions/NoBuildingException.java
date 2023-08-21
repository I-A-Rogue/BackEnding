package net.weg.wegproject.concreteClasses.productsClasses.building.exceptions;

public class NoBuildingException extends RuntimeException{
    public NoBuildingException() {
        super("building inexitente");
    }
}

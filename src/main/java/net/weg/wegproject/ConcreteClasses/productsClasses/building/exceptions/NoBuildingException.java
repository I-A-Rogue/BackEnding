package net.weg.wegproject.ConcreteClasses.productsClasses.building.exceptions;

public class NoBuildingException extends RuntimeException{
    public NoBuildingException() {
        super("building inexitente");
    }
}

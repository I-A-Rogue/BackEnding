package net.weg.wegproject.building.exceptions;

public class NoBuildingException extends RuntimeException{
    public NoBuildingException() {
        super("building inexitente");
    }
}

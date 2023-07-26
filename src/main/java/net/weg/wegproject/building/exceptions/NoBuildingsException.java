package net.weg.wegproject.building.exceptions;

public class NoBuildingsException extends RuntimeException{
    public NoBuildingsException() {
        super("Não exite nenhuma building cadastrada");
    }
}

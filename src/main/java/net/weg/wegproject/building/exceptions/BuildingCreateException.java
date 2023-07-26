package net.weg.wegproject.building.exceptions;

public class BuildingCreateException extends RuntimeException{
    public BuildingCreateException() {
        super("Não foi possivel criar esta building");
    }
}

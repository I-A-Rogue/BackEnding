package net.weg.wegproject.building.exceptions;

public class BuildingDeleteException extends RuntimeException{
    public BuildingDeleteException() {
        super("Não foi possivel deletar esta building");
    }
}

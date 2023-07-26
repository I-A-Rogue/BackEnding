package net.weg.wegproject.building.exceptions;

public class BuildingUpdateException extends RuntimeException{
    public BuildingUpdateException() {
        super("Não foi possível editar esta building");
    }
}

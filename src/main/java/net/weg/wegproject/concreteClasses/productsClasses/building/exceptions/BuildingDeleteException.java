package net.weg.wegproject.concreteClasses.productsClasses.building.exceptions;

public class BuildingDeleteException extends RuntimeException{
    public BuildingDeleteException() {
        super("Não foi possivel deletar esta building");
    }
}

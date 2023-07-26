package net.weg.wegproject.categories.exceptions;

public class CategorieDeleteException extends RuntimeException{
    public CategorieDeleteException() {
        super("Não foi possivel deletar este categoria");
    }
}

package net.weg.wegproject.categories.exceptions;

public class CategorieUpdateException extends RuntimeException{
    public CategorieUpdateException() {
        super("Não foi possível editar este categoria");
    }
}

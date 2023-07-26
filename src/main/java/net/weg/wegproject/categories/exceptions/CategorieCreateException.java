package net.weg.wegproject.categories.exceptions;

public class CategorieCreateException extends RuntimeException{
    public CategorieCreateException() {
        super("Não foi possivel criar este categoria");
    }
}

package net.weg.wegproject.categories.exceptions;

public class NoCategorieException extends RuntimeException{
    public NoCategorieException() {
        super("Não exite nenhum categoria cadastrada");
    }
}

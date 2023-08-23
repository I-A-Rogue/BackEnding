package net.weg.wegproject.ink.exceptions;

public class NoInksException extends RuntimeException{
    public NoInksException() {
        super("Não exite nenhuma tinta cadastrada");
    }
}

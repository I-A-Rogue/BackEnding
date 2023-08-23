package net.weg.wegproject.ink.exceptions;

public class InkUpdateException extends RuntimeException{
    public InkUpdateException() {
        super("Não foi possível editar esta tinta");
    }
}

package net.weg.wegproject.ink.exceptions;

public class InkDeleteException extends RuntimeException{
    public InkDeleteException() {
        super("Não foi possivel deletar esta tinta");
    }
}

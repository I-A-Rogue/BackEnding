package net.weg.wegproject.ink.exceptions;

public class InkCreateException extends RuntimeException{
    public InkCreateException() {
        super("Não foi possivel criar esta tinta");
    }
}

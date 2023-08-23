package net.weg.wegproject.ink.exceptions;

public class NoInkException extends RuntimeException{
    public NoInkException() {
        super("Tinta inexitente");
    }
}

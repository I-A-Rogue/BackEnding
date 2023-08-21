package net.weg.wegproject.assessment.exceptions;

public class NoAssessmentsException extends RuntimeException{
    public NoAssessmentsException() {
        super("Não exite nenhuma avaliação cadastrada");
    }
}

package net.weg.wegproject.concreteClasses.assessment.exceptions;

public class NoAssessmentsException extends RuntimeException{
    public NoAssessmentsException() {
        super("Não exite nenhuma avaliação cadastrada");
    }
}

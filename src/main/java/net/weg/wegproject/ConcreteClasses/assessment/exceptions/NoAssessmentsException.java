package net.weg.wegproject.ConcreteClasses.assessment.exceptions;

public class NoAssessmentsException extends RuntimeException{
    public NoAssessmentsException() {
        super("Não exite nenhuma avaliação cadastrada");
    }
}

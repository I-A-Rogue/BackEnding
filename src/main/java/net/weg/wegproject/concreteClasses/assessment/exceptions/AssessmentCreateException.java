package net.weg.wegproject.concreteClasses.assessment.exceptions;

public class AssessmentCreateException extends RuntimeException{
    public AssessmentCreateException() {
        super("Não foi possivel criar esta avaliação");
    }
}

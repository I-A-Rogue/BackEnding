package net.weg.wegproject.concreteClasses.assessment.exceptions;

public class AssessmentDeleteException extends RuntimeException{
    public AssessmentDeleteException() {
        super("Não foi possivel deletar esta avaliação");
    }
}

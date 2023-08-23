package net.weg.wegproject.ConcreteClasses.assessment.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class AssessmentDTO {

    @NotBlank(message = "Quantidade de votos não pode ser nula!")
    private Integer amountVotes;
    @NotBlank(message = "Avaliação não pode ser nula!")
    private Integer assessment;

}
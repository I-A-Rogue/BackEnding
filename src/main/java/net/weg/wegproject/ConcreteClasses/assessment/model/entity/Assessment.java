package net.weg.wegproject.ConcreteClasses.assessment.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer amountVotes;
    Integer assessment;
    Integer totalAssessment;

}
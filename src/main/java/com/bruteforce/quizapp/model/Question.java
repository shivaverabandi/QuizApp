package com.bruteforce.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  //  (@Getter + @Setter + @ToString + @EqualsAndHashCode)
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private Integer Id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String difficultLevel;
    private String category;


}

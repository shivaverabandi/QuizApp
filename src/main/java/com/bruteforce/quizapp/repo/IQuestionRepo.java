package com.bruteforce.quizapp.repo;

import com.bruteforce.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // It is not mandatory but for developers readability better to mention
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}

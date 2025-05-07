package com.bruteforce.quizapp.repo;

import com.bruteforce.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // It is not mandatory but for developers readability better to mention
public interface IQuestionRepo extends JpaRepository<Question, Integer> {

    // find by column category --> this will implement by proxy class in spring ioc
    List<Question> findByCategory(String category);
}

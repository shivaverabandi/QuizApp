package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuestionService {
    ResponseEntity<List<Question>> getAllQuestions();

    ResponseEntity<Long> getNumberOfQuestions();

    ResponseEntity<List<Question>> getQuestionsByCategory(String category);

    ResponseEntity<List<Question>> getQuestionByLevel(String level);

    ResponseEntity<String> addQuestion(Question question);

    ResponseEntity<String> deleteQuestion(Integer id);

}

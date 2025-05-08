package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getAllQuestions();
    Long getNumberOfQuestions();
    List<Question> getQuestionsByCategory(String category);
    String addQuestion(Question question);
    String deleteQuestion(Integer id);
}

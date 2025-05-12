package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.model.QuestionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface IQuizService {

    ResponseEntity<Set<Question>> createQuiz(String category, int n_ques, String title);

    ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id);
}

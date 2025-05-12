package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IQuizService {

    ResponseEntity<Set<Question>> createQuiz(String category, int n_ques, String title);
}

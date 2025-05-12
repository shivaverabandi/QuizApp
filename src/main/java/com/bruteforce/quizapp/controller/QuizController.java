package com.bruteforce.quizapp.controller;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/create-q")
    public ResponseEntity<Set<Question>> createQuiz(
                @RequestParam String category,
                @RequestParam int n_ques,
                @RequestParam String title) {
        return quizService.createQuiz(category,n_ques,title);

    }
}

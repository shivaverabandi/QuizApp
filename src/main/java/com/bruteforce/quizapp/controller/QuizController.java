package com.bruteforce.quizapp.controller;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.model.QuestionWrapper;
import com.bruteforce.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    // admin created quiz
    @GetMapping("/create-q")
    public ResponseEntity<Set<Question>> createQuiz(
                @RequestParam String category,
                @RequestParam int n_ques,
                @RequestParam String title) {
        return quizService.createQuiz(category,n_ques,title);
    }

    // user asked for quiz
    @GetMapping("/get-q/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }


}

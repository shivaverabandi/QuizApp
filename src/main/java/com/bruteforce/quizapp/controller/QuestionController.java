package com.bruteforce.quizapp.controller;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;


    @GetMapping("/all-questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/total-questions")
    public String getCount(){
        return questionService.getNumberOfQuestions().toString();
    }
    @GetMapping("/by-topic/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add-q")
    public String addQuestion(@RequestBody Question question){
        System.out.println(question); // for debugging purpose
       return questionService.addQuestion(question);
    }
    @DeleteMapping("/delete-q")
    public String deleteQuestion(@RequestBody Integer questionNumber){
        return questionService.deleteQuestion(questionNumber);
    }
}

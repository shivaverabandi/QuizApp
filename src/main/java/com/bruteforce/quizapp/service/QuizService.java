package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.model.Quiz;
import com.bruteforce.quizapp.repo.IQuestionRepo;
import com.bruteforce.quizapp.repo.IQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizService implements IQuizService {

    @Autowired
    private IQuizRepo quizRepo;

    @Autowired
    private IQuestionRepo questionRepo;
    @Override
    public ResponseEntity<Set<Question>> createQuiz(String category, int n_ques, String title) {
        Set<Question> questions = questionRepo.findRandomQuestionsByCategory(category,n_ques);
        Quiz quiz = new Quiz(); // create an object for Quiz Model
        quiz.setTitle(title); // set the title for quiz
        quiz.setQuestionList(questions); // setting the questions into set.
        quizRepo.save(quiz); // saving the quiz to Quiz Table
        if(!questions.isEmpty()) {
            return new ResponseEntity<>(questions, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new HashSet<Question>(), HttpStatus.NO_CONTENT);
    }
}

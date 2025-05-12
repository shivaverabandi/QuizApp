package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.model.QuestionWrapper;
import com.bruteforce.quizapp.model.Quiz;
import com.bruteforce.quizapp.repo.IQuestionRepo;
import com.bruteforce.quizapp.repo.IQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class QuizService implements IQuizService {

    @Autowired
    private IQuizRepo quizRepo;

    @Autowired
    private IQuestionRepo questionRepo;

    // admin method --> who creates quiz
    @Override
    public ResponseEntity<Set<Question>> createQuiz(String category, int n_ques, String title) {

        Set<Question> questions = questionRepo.findRandomQuestionsByCategory(category,n_ques);

        // Quiz entity created and saved in database.
        Quiz quiz = new Quiz(); // create an object for Quiz Model
        quiz.setTitle(title); // set the title for quiz
        quiz.setQuestionList(questions); // setting the questions into set.
        quizRepo.save(quiz); // saving the quiz to Quiz Table

        /*
        newly created quiz is returned to admin by getMapping where I used Query Parameter,
        because returning list of json objects to the web browser.
        If it is a particular question then go with path parameter.

        */
        if(!questions.isEmpty()) {
            return new ResponseEntity<>(questions, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new HashSet<>(), HttpStatus.NO_CONTENT);
    }

    // User method --> who plays Quiz
    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Optional<Quiz> quesWithAns = quizRepo.findById(id); // this is from Quiz Table

        Set<Question> ques = quesWithAns.get().getQuestionList(); // questions list with answers

        List<QuestionWrapper> onlyQuestion = extractQuestionWrapperList(ques);


        if(ques.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(onlyQuestion, HttpStatus.OK);

    }

    // converting questions to Question Wrapper
    private List<QuestionWrapper> extractQuestionWrapperList(Set<Question> ques) {
        List<QuestionWrapper> onlyQuestion = new ArrayList<>();
        for(Question qwitha : ques) { // qwitha --> question with answer

            QuestionWrapper qw = new QuestionWrapper(
                     qwitha.getId() , qwitha.getQuestionTitle()
                    ,qwitha.getOption1() , qwitha.getOption2()
                    ,qwitha.getOption3() , qwitha.getOption4()
            ); // creating question with options only

            onlyQuestion.add(qw);
        }
        return onlyQuestion;
    }
}

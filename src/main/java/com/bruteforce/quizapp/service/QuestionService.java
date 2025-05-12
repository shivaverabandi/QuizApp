package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.repo.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepo questionRepo;


    // return all total questions which are in database
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            List<Question> questions = questionRepo.findAll();
            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
    }

    // total number of questions in database
    @Override
    public ResponseEntity<Long> getNumberOfQuestions() {
        try{
            long count = questionRepo.count();
            if(count == 0){

                return new ResponseEntity<>(-1L, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(count,HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(-1L, HttpStatus.BAD_REQUEST);
    }

    // get questions from database by category wise
    // example if category = java then all java questions will be displayed
    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            List<Question> questions = questionRepo.findByCategory(category);
            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(questions,HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
    }

    // return questions according to difficulty level
    @Override
    public ResponseEntity<List<Question>> getQuestionByLevel(String level) {
        try{
            List<Question> list = questionRepo.findByDifficultLevel(level);
            if(list.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list ,HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
    }


    // add new question to database
    @Override
    public ResponseEntity<String> addQuestion(Question question) {
        try{
            Question q = questionRepo.save(question);
            return new ResponseEntity<>("Saved Successfully",HttpStatus.CREATED);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Not able to Save...! ",HttpStatus.UNAUTHORIZED);

    }


    // Delete question by id method
    @Override
    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            if(questionRepo.existsById(id)) {
                questionRepo.deleteById(id);
                return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Not able to Delete...! ",HttpStatus.UNAUTHORIZED);
    }

}

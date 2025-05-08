package com.bruteforce.quizapp.service;

import com.bruteforce.quizapp.model.Question;
import com.bruteforce.quizapp.repo.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepo questionRepo;


    @Override
    public List<Question> getAllQuestions() {
       return questionRepo.findAll();
    }

    @Override
    public Long getNumberOfQuestions() {
        return questionRepo.count();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public String addQuestion(Question question) {

        Question q = questionRepo.save(question);
        return q == null ? "Not Successfully added...!!!" : "successfully addded";
    }

    @Override
    public String deleteQuestion(Integer id) {
        if(questionRepo.existsById(id)) {
            questionRepo.deleteById(id);
            return "Successfully deleted question...!!!";
        }
        return "Not Successfully deleted question...!!!";
    }

}

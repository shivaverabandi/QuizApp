package com.bruteforce.quizapp.repo;

import com.bruteforce.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepo extends JpaRepository<Quiz,Integer> {

}

package com.bruteforce.quizapp.repo;

import com.bruteforce.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository // It is not mandatory but for developers readability better to mention
public interface IQuestionRepo extends JpaRepository<Question, Integer> {

    // find by column category --> this will implement by proxy class in spring ioc
    List<Question> findByCategory(String category);

    List<Question>findByDifficultLevel(String level);

    @Query(value = "SELECT * FROM question q WHERE q.category =:category ORDER BY RAND() LIMIT :nQues "
            ,nativeQuery = true)
    Set<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("nQues") int nQues);

}

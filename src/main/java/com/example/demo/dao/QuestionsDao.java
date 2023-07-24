package com.example.demo.dao;

import com.example.demo.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Questions,Integer> {
    //write additional functions
    public List<Questions> findByCategory(String category);
    @Query(value = "select * from qna q where q.category = :category order by RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questions> findRandomQueByCategory(@Param("category") String category, @Param("numQ") Integer numQ);
}

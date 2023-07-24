package com.example.demo.services;

import com.example.demo.dao.QuestionsDao;
import com.example.demo.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionsDao questionsDao;

    public List<Questions> getAllQue(){
        return questionsDao.findAll();
    }

    public List<Questions> getQueByCategory(String category) {
        return questionsDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        questionsDao.save(question);
        return new ResponseEntity<>("successfully added", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addQuestions(List<Questions> questionsList) {
        int count = 0;
        for (Questions questions : questionsList) {
            questionsDao.save(questions);
            count++;
        }
        return new ResponseEntity<>(count+" record(s) are successfully saved", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        questionsDao.deleteById(id);
        return new ResponseEntity<>("DELETED SUCCESSFULLY",HttpStatus.OK);
    }
}

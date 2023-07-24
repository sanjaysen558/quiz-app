package com.example.demo.controllers;

import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.QuizResponse;
import com.example.demo.services.QuizService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam Integer numQ,
                                             @RequestParam String label){
        return quizService.createQuiz(category,numQ,label);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<QuestionWrapper> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponseList){
        return quizService.submitQuiz(id,quizResponseList);
    }
}

package com.example.demo.controllers;

import com.example.demo.model.Questions;
import com.example.demo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QnaController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping(value = "/allQuestions")
    public List<Questions> getAllQue(){
        return questionService.getAllQue();
    }
    @GetMapping("/category/{category}")
    public List<Questions> getQueByCategory(@PathVariable  String category){
        return questionService.getQueByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return questionService.addQuestion(questions);
    }

    @PostMapping("/add-multiple")
    public ResponseEntity<String> addQuestions(@RequestBody List<Questions> questions){
        return questionService.addQuestions(questions);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}

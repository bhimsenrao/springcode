package com.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onetomany.entity.Answer;
import com.onetomany.entity.Question;
import com.onetomany.entity.QuestionRequest;
import com.onetomany.service.QueAnsService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QAController {

    @Autowired
    private QueAnsService service;

    @GetMapping("/{id}")
    public Map<Question, List<Answer>> getQuest(@PathVariable("id") Integer id) {
        return service.getQuest(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionRequest request) {
        Question question = request.getQuestion();
        List<Answer> answers = request.getAnswers();
        service.addQuest(question, answers, answers.get(0).getPostedBy());
        return new ResponseEntity<>("Question and answers saved successfully", HttpStatus.OK);
    }
    
    @PutMapping("/upd")
    public ResponseEntity<String> updQuestion(@RequestBody QuestionRequest request) {
        Question question = request.getQuestion();
        List<Answer> answers = request.getAnswers();
        service.addQuest(question, answers, answers.get(0).getPostedBy());
        return new ResponseEntity<>("Question and answers updated successfully", HttpStatus.OK);
    }
    
}
/*
 * Post:  url-->http://localhost:9900/api/questions/add
 * Put: url--> http://localhost:9900/api/questions/upd
 { "question": 
    { "qname": "What is Spring Boot?" }, 
    "answers": [ 
        { "answername": "Spring Boot is a framework that simplifies the development of Java applications.", 
          "postedBy": "bhimsen" }, 
        { "answername": "It provides a range of features to help with the development, testing, and deployment of Java applications.", 
          "postedBy": "bhimsen" } 
             ] 
} 
 */

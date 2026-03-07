package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    // Add Question
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    // Get Questions by Quiz ID
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuiz(@PathVariable Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Quiz;
import com.example.demo.entity.Question;
import com.example.demo.entity.Result;
import com.example.demo.dto.SubmitQuizDTO;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.ResultRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;

    // ✅ Create Quiz
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // ✅ Get All Quizzes
    @GetMapping("/all")
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // ✅ Submit Quiz & Calculate Score
    @PostMapping("/submit")
    public Result submitQuiz(@RequestBody SubmitQuizDTO submitQuizDTO) {

        Long userId = submitQuizDTO.getUserId();
        Long quizId = submitQuizDTO.getQuizId();
        Map<Long, String> userAnswers = submitQuizDTO.getAnswers();

        int score = 0;

        // Get all questions for this quiz
        List<Question> questions = questionRepository.findByQuizId(quizId);

        for (Question question : questions) {

            String correctAnswer = question.getCorrectAnswer();
            String userAnswer = userAnswers.get(question.getId());

            if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
                score++;
            }
        }

        Result result = new Result(userId, quizId, score);

        return resultRepository.save(result);
    }
}
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.ResultRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.QuizRepository;
import com.example.demo.service.CertificateService;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private CertificateService certificateService;

    // Get results by user
    @GetMapping("/user/{userId}")
    public List<Result> getResultsByUser(@PathVariable Long userId) {
        return resultRepository.findByUserId(userId);
    }

    // Download Certificate (HTML Certificate)
    @GetMapping("/certificate/{resultId}")
    public ResponseEntity<String> downloadCertificate(@PathVariable Long resultId) {

        // 1️⃣ Get Result
        Result result = resultRepository.findById(resultId).orElse(null);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        // 2️⃣ Get User
        User user = userRepository.findById(result.getUserId()).orElse(null);

        // 3️⃣ Get Quiz
        Quiz quiz = quizRepository.findById(result.getQuizId()).orElse(null);

        if (user == null || quiz == null) {
            return ResponseEntity.notFound().build();
        }

        // 4️⃣ Generate Certificate HTML
        String certificateHtml = certificateService.generateCertificate(
                user.getName(),
                quiz.getTitle(),
                result.getScore()
        );

        // 5️⃣ Return HTML page
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/html")
                .body(certificateHtml);
    }
}
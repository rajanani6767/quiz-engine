package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.QuizRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(QuizRepository quizRepository, QuestionRepository questionRepository) {

        return args -> {

            if (quizRepository.count() == 0) {

                Quiz quiz = new Quiz();
                quiz.setTitle("Java Basics");

                quiz = quizRepository.save(quiz);

                Question q1 = new Question();
                q1.setQuestionTitle("What is JVM?");
                q1.setOptionA("Java Virtual Machine");
                q1.setOptionB("Java Variable Method");
                q1.setOptionC("Java Version Manager");
                q1.setOptionD("None");
                q1.setCorrectAnswer("Java Virtual Machine");
                q1.setQuizId(quiz.getId());

                Question q2 = new Question();
                q2.setQuestionTitle("Which keyword creates object?");
                q2.setOptionA("class");
                q2.setOptionB("new");
                q2.setOptionC("object");
                q2.setOptionD("create");
                q2.setCorrectAnswer("new");
                q2.setQuizId(quiz.getId());

                questionRepository.save(q1);
                questionRepository.save(q2);
            }
        };
    }
}
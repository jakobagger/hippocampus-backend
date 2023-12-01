package memgrp.memorize.service;

import memgrp.memorize.dto.QuizResponse;
import memgrp.memorize.entity.Quiz;
import memgrp.memorize.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<QuizResponse> getDefaultQuiz() {
       List<Quiz> defaultQuiz = quizRepository.findAllByIsDefault(true);
       List<QuizResponse> response = defaultQuiz.stream().map(QuizResponse::new).toList();
       return response;
    }
}

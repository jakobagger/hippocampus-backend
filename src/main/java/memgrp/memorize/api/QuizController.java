package memgrp.memorize.api;

import memgrp.memorize.dto.QuizResponse;
import memgrp.memorize.service.QuizService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping()
    public List<QuizResponse> getDefaultQuiz() {
        List<QuizResponse> responses = quizService.getDefaultQuiz();
        return responses;

    }
}


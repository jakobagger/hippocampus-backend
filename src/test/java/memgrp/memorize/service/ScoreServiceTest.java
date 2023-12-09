package memgrp.memorize.service;

import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Quiz;
import memgrp.memorize.entity.Score;
import memgrp.memorize.repository.ScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScoreServiceTest {


    @InjectMocks
    ScoreService scoreService;

    @Mock
    ScoreRepository scoreRepository;

    Quiz quiz;

    Member m1;

    @BeforeEach
    void setup() {
        m1 = new Member("username", "password", "email");
        quiz = new Quiz(1,"quiz",52,m1,true,null,null);
    }
    @Test
    void addScoreToQuizWithUsername() {
        Score score = new Score(1,"200 seconds", "0 out of 52",m1,quiz);
        when(scoreRepository.save(any(Score.class))).thenReturn(score);
    }
}
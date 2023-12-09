package memgrp.memorize.service;

import memgrp.memorize.dto.ScoreRequest;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Quiz;
import memgrp.memorize.entity.Score;
import memgrp.memorize.repository.MemberRepository;
import memgrp.memorize.repository.QuizRepository;
import memgrp.memorize.repository.ScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScoreServiceTest {


    @InjectMocks
    ScoreService scoreService;

    @Mock
    ScoreRepository scoreRepository;

    @Mock
    QuizRepository quizRepository;

    @Mock
    MemberRepository memberRepository;
    Quiz quiz;

    Member m1;

    @BeforeEach
    void setup() {
        m1 = new Member("username", "password", "email");
        quiz = new Quiz(1,"quiz",52,m1,true,null,null);
    }
    @Test
    void addScoreToQuizWithUsername() {
        ScoreRequest request = new ScoreRequest("1 out of 52","199 seconds","username",1);
        Score score = ScoreRequest.getScoreEntity(request);
        score.setQuiz(quiz);
        score.setMember(m1);
        when(quizRepository.findById(1)).thenReturn(Optional.of(quiz));
        when(memberRepository.findById("username")).thenReturn(Optional.of(m1));
        when(scoreRepository.save(any(Score.class))).thenReturn(score);

        scoreService.addScoreToQuizWithUsername(request);
        assertEquals("username",score.getMember().getUsername());
        verify(quizRepository).findById(1);
        verify(memberRepository).findById("username");
        verify(scoreRepository).save(any(Score.class));

    }
}
package memgrp.memorize.service;

import memgrp.memorize.dto.ScoreRequest;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Quiz;
import memgrp.memorize.entity.Score;
import memgrp.memorize.repository.MemberRepository;
import memgrp.memorize.repository.QuizRepository;
import memgrp.memorize.repository.ScoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScoreService {



    ScoreRepository scoreRepository;

    QuizRepository quizRepository;

    MemberRepository memberRepository;

    public ScoreService(ScoreRepository scoreRepository, QuizRepository quizRepository, MemberRepository memberRepository) {
        this.scoreRepository = scoreRepository;
        this.quizRepository = quizRepository;
        this.memberRepository = memberRepository;
    }

    public void addScoreToQuizWithUsername(ScoreRequest body) {
        Quiz quiz = quizRepository.findById(body.getQuiz_id())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find quiz with that id"));
        Member member = memberRepository.findById(body.getUsername())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find quiz with that id"));
        Score score = ScoreRequest.getScoreEntity(body);
        score.setQuiz(quiz);
        score.setMember(member);
        scoreRepository.save(score);
    }
}

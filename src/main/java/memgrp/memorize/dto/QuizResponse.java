package memgrp.memorize.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Quiz;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class QuizResponse {

    int id;
    String quizName;
    int quizSize;
    Member member;
    boolean isDefault;

    List<CardResponse> cards;

    public QuizResponse(Quiz quiz)  {
        this.id = quiz.getId();
        this.quizName = quiz.getQuizName();
        this.isDefault = quiz.isDefault();
        this.cards = quiz.getCards().stream().map(CardResponse::new).toList();
    }
}

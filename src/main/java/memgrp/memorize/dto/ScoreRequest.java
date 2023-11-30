package memgrp.memorize.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Score;

@Getter
@Setter
@NoArgsConstructor
public class ScoreRequest {

    String scoreNumber;

    String time;

    String username;

    int quiz_id;

    public ScoreRequest(String scoreNumber, String time, String username, int quiz_id) {
        this.scoreNumber = scoreNumber;
        this.time = time;
        this.username = username;
        this.quiz_id = quiz_id;
    }

    public static Score getScoreEntity(ScoreRequest r) {
        return new Score(r.getScoreNumber(),r.getTime());
    }


}

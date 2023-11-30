package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int scoreId;

    String time;

    String scoreNumber;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    Member member;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    Quiz quiz;

    public Score(String scoreNumber, String time) {
        this.scoreNumber = scoreNumber;
        this.time = time;
    }
}

package memgrp.memorize.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quizName;
    private int quizSize;

    @ManyToOne
    @JoinColumn(name = "username")
    Member member;

    @Column(name = "is_default")
    boolean isDefault;

    @ManyToMany
    @JoinTable(
            name = "quiz_card",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
            )
    List<Card> cards;

    @OneToMany(mappedBy = "quiz")
    List<Score> scoreList;

    public void addScore(Score score) {
        if(scoreList==null) {
            scoreList = new ArrayList<>();
        }
        scoreList.add(score);
    }

    public void addCard(Card card) {
        if(cards==null) {
            cards = new ArrayList<>();
        }
        cards.add(card);
    }
}

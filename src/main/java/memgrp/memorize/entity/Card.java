package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    @ManyToOne
    @JoinColumn(name="matrix_id")
    private Matrix matrix;
    @ManyToOne
    @JoinColumn(name = "value_id")
    private Value value;
    @ManyToOne
    @JoinColumn(name ="suit_id")
    private Suit suit;
    private String person;
    private String action;
    private String object;
    @Lob
    @Column(name = "image", length = 1234567)
    private String base64;

    @ManyToMany(mappedBy = "cards")
    List<Quiz> quizList;

    public void addQuiz(Quiz quiz) {
        if(quizList==null) {
            quizList = new ArrayList<>();
        }
        quizList.add(quiz);
    }


    public Card(Value value, Suit suit, String person, String action, String object, String base64) {
        this.value = value;
        value.addCard(this);
        this.suit = suit;
        suit.addCard(this);
        this.person = person;
        this.action = action;
        this.object = object;
        this.base64 = base64;
    }
}

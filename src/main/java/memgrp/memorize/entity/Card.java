package memgrp.memorize.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private String value;
    private String suit;
    private String person;
    private String action;
    private String object;
    @Lob
    @Column(name = "image", length = 1234567)
    private String Base64;


    public Card(String value, String suit, String person, String action, String object, String Base64) {
        this.value = value;
        this.suit = suit;
        this.person = person;
        this.action = action;
        this.object = object;
        this.Base64 = Base64;
    }

}

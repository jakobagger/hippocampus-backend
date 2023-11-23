package memgrp.memorize.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String imageBase64;


    public Card(int cardId, String value, String suit, String person, String action, String object, String imageBase64) {
        this.cardId = cardId;
        this.value = value;
        this.suit = suit;
        this.person = person;
        this.action = action;
        this.object = object;
        this.imageBase64 = imageBase64;
    }









}

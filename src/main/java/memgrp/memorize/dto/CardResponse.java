package memgrp.memorize.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Card;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

    String value;
    String suit;
    String person;
    String action;
    String object;
    String image;

    public CardResponse(Card card) {
        this.value = card.getValue().getValueName();
        this.suit = card.getSuit().getSuitName();
        this.person = card.getPerson();
        this.action = card.getAction();
        this.object = card.getObject();
        this.image = card.getBase64();
    }
}

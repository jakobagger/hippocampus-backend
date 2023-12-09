package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Suit;

@Getter
@Setter
@NoArgsConstructor
public class SuitResponse {

    int suitId;
    String suitName;
    String suitDescription;

    public SuitResponse(Suit suit){
        this.suitId = suit.getSuitId();
        this.suitName = suit.getSuitName();
        this.suitDescription = suit.getSuitDescription();
    }
}

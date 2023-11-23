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
    String suitDescription;

    public SuitResponse(Suit suit){
        this.suitId = suit.getSuitId();
        this.suitDescription = suit.getSuitDescription();
    }
}

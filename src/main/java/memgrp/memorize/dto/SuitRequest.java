package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Suit;

@Getter
@Setter
@NoArgsConstructor
public class SuitRequest {

    int suitId;
    String suitName;
    String suitDescription;
    int matrixId;

    public static Suit getSuitEntity(SuitRequest suit) {
       return new Suit(suit.getSuitName(), suit.getSuitDescription());
    }
}

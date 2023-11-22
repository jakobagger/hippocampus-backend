package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuitRequest {

    String suitDescription;

    public SuitRequest(String suitDescription){
        this.suitDescription = suitDescription;
    }

}

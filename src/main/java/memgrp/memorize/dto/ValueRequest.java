package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValueRequest {

    String valueDescription;
    int valueNumber;

    public ValueRequest(String valueDescription, int valueNumber){
        this.valueDescription = valueDescription;
        this.valueNumber = valueNumber;
    }
}

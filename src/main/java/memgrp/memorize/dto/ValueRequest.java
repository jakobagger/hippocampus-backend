package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValueRequest {

    String valueDescription;
    int valueName;

    public ValueRequest(String valueDescription, int valueName){
        this.valueDescription = valueDescription;
        this.valueName = valueName;
    }
}

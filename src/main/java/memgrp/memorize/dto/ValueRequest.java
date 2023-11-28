package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValueRequest {

    String valueDescription;
    String valueName;
    public ValueRequest(String valueDescription, String valueName){
        this.valueDescription = valueDescription;
        this.valueName = valueName;
    }
}

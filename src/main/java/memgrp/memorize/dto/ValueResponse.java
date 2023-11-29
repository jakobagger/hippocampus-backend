package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Value;
@Getter
@Setter
@NoArgsConstructor
public class ValueResponse {

    int valueId;
    String valueDescription;
    String valueName;

    public ValueResponse(Value value){
        this.valueId = value.getValueId();
        this.valueDescription = value.getValueDescription();
        this.valueName = value.getValueName();
    }
}

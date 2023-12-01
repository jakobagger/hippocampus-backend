package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Value;

@Getter
@Setter
@NoArgsConstructor
public class ValueRequest {

    int valueId;
    String valueDescription;
    String valueName;

    public ValueRequest(int valueId, String valueDescription, String valueName){
        this.valueId = valueId;
        this.valueDescription = valueDescription;
        this.valueName = valueName;
    }

    public static Value getValueEntity(ValueRequest value) {
        return new Value(value.getValueName(), value.getValueDescription());
    }
}

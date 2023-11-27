package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValueRequest {

    String categoryDescription;
    int categoryNumber;

    public ValueRequest(String categoryDescription, int categoryNumber){
        this.categoryDescription = categoryDescription;
        this.categoryNumber = categoryNumber;
    }
}

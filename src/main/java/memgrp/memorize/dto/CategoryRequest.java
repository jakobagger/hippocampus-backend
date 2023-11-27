package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryRequest {

    String categoryDescription;
    int categoryNumber;

    public CategoryRequest(String categoryDescription, int categoryNumber){
        this.categoryDescription = categoryDescription;
        this.categoryNumber = categoryNumber;
    }
}

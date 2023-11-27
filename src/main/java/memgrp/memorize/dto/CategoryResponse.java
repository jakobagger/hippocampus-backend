package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Category;
@Getter
@Setter
@NoArgsConstructor
public class CategoryResponse {

    int categoryId;
    String categoryDescription;
    int categoryNumber;

    public CategoryResponse(Category category){
        this.categoryId = category.getCategoryId();
        this.categoryDescription = category.getCategoryDescription();
        this.categoryNumber = category.getCategoryNumber();
    }
}

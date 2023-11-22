package memgrp.memorize.dto;

import memgrp.memorize.entity.Category;

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

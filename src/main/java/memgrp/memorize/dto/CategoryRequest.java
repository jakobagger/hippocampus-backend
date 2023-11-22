package memgrp.memorize.dto;

public class CategoryRequest {

    String categoryDescription;
    int categoryNumber;

    public CategoryRequest(String categoryDescription, int categoryNumber){
        this.categoryDescription = categoryDescription;
        this.categoryNumber = categoryNumber;
    }
}

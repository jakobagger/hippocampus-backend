package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import memgrp.memorize.entity.Matrix;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MatrixResponse {

    int matrixId;

    List<SuitResponse> suits;
    List<CategoryResponse> categories;
//    List<CardResponse> cards;

    public MatrixResponse(Matrix matrix){
        this.matrixId = matrix.getMatrixId();
        if(matrix.getSuits() != null){
            this.suits = matrix.getSuits().stream().map(SuitResponse::new).toList();
        }
        if (matrix.getCategories() != null){
            this.categories = matrix.getCategories().stream().map(CategoryResponse::new).toList();
        }
//        if (matrix.getCards() != null){
//            this.cards = matrix.getCards().stream().map(CardsResponse::new).toList();
//        }
    }
}

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
    String matrixName;
    List<SuitResponse> suits;
    List<ValueResponse> values;
    List<CardResponse> cards;

    public MatrixResponse(Matrix matrix){
        this.matrixId = matrix.getMatrixId();
        this.matrixName = matrix.getMatrixName();
        if(matrix.getSuits() != null){
            this.suits = matrix.getSuits().stream().map(SuitResponse::new).toList();
        }
        if (matrix.getValues() != null){
            this.values = matrix.getValues().stream().map(ValueResponse::new).toList();
        }
        if (matrix.getCards() != null){
        this.cards = matrix.getCards().stream().map(CardResponse::new).toList();
        }
    }
}

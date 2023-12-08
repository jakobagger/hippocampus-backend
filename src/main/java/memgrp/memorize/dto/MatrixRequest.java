package memgrp.memorize.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatrixRequest {

    int matrixId;
    String matrixName;

    public static Matrix getMatrixEntity(MatrixRequest matrix){
        return new Matrix(matrix.getMatrixId(), matrix.getMatrixName());
    }
}

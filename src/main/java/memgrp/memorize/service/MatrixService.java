package memgrp.memorize.service;

import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.repository.MatrixRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MatrixService {

    MatrixRepository matrixRepository;

    public MatrixService(MatrixRepository matrixRepository){
        this.matrixRepository = matrixRepository;
    }
    public List<MatrixResponse> getMatrix() {
        List<Matrix> matrixList = matrixRepository.findAll();
        List<MatrixResponse> responses = new ArrayList<>();
        for(Matrix matrix : matrixList){
            MatrixResponse matrixResponse = new MatrixResponse(matrix);
            responses.add(matrixResponse);
        }
        return responses;
    }
}

package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.entity.Card;
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

    public void addCardToMatrix(Card card, int matrixId) {
        Matrix matrix = matrixRepository.findById(matrixId)
                .orElseThrow(() -> new EntityNotFoundException("Matrix not found"));
        matrix.addCard(card);
        matrixRepository.save(matrix);
    }



}

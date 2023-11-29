package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.entity.Card;

import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.SuitRepository;
import memgrp.memorize.repository.ValueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MatrixService {

    MatrixRepository matrixRepository;
    ValueRepository valueRepository;
    SuitRepository suitRepository;
    public MatrixService(MatrixRepository matrixRepository, ValueRepository valueRepository, SuitRepository suitRepository){
        this.matrixRepository = matrixRepository;
        this.valueRepository = valueRepository;
        this.suitRepository = suitRepository;
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

    public List<ValueResponse> getValue(){
        List<Value> values = valueRepository.findAll();
        List<ValueResponse> responses = new ArrayList<>();
        for(Value value : values){
            ValueResponse valueResponse = new ValueResponse(value);
            responses.add(valueResponse);
        }
        return responses;
    }

    public List<SuitResponse> getSuit() {
        List<Suit> suits = suitRepository.findAll();
        List<SuitResponse> responses = new ArrayList<>();
        for (Suit suit : suits){
            SuitResponse suitResponse = new SuitResponse(suit);
            responses.add(suitResponse);
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

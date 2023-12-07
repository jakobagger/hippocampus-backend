package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.MatrixRequest;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.MemberRepository;
import memgrp.memorize.repository.SuitRepository;
import memgrp.memorize.repository.ValueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Service
public class MatrixService {

    MatrixRepository matrixRepository;

    MemberRepository memberRepository;
    ValueRepository valueRepository;
    SuitRepository suitRepository;
    public MatrixService(MatrixRepository matrixRepository, MemberRepository memberRepository, ValueRepository valueRepository, SuitRepository suitRepository){
        this.matrixRepository = matrixRepository;
        this.memberRepository = memberRepository;
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

    public MatrixResponse addMatrix(MatrixRequest body){
        if(matrixRepository.existsById(body.getMatrixId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Matrix already exist");
        }
        Matrix newMatrix = MatrixRequest.getMatrixEntity(body);
        newMatrix = matrixRepository.save(newMatrix);

    return new MatrixResponse(newMatrix);
    }






    public void addCardToMatrix(Card card, int matrixId) {
        Matrix matrix = matrixRepository.findById(matrixId)
                .orElseThrow(() -> new EntityNotFoundException("Matrix not found"));
        matrix.addCard(card);
        matrixRepository.save(matrix);
    }

    public MatrixResponse getDefaultMatrix() {
        Matrix matrix = matrixRepository.findById(1).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Default Matrix doesn't exist"));
        MatrixResponse response = new MatrixResponse(matrix);
        return response;
    }
}

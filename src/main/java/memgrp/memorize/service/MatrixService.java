package memgrp.memorize.service;
import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.MatrixRequest;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.entity.*;
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
        this.suitRepository = suitRepository
    ValueRepository valueRepository;
    SuitRepository suitRepository;

    public MatrixService(MatrixRepository matrixRepository, ValueRepository valueRepository, SuitRepository suitRepository){
        this.matrixRepository = matrixRepository;

        ;
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

package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.ValueRequest;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValueService {


    private ValueRepository valueRepository;
    private MatrixRepository matrixRepository;

    public ValueService(ValueRepository valueRepository, MatrixRepository matrixRepository){
        this.valueRepository = valueRepository;
        this.matrixRepository = matrixRepository;
    }

    public ValueResponse addValue(ValueRequest body){
        if(valueRepository.existsById(body.getValueId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Value already exist");
        }
        Value newValue = ValueRequest.getValueEntity(body);
        valueRepository.save(newValue);
        return new ValueResponse(newValue);
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


    public void addCardToValue(Card card, int valueId) {
        Value value = valueRepository.findById(valueId)
                .orElseThrow(() -> new EntityNotFoundException("Value not found"));

        value.addCard(card);
        valueRepository.save(value); // Corrected method invocation
    }

}

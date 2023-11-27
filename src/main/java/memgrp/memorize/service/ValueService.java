package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueService {

    @Autowired
    private ValueRepository valueRepository;


    public void addCardToValue(Card card, int valueId) {
        Value value = valueRepository.findById(valueId)
                .orElseThrow(() -> new EntityNotFoundException("Value not found"));

        value.addCard(card);
        valueRepository.save(value); // Corrected method invocation
    }




}

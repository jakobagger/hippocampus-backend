package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.SuitRequest;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.SuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuitService {

    @Autowired
    private SuitRepository suitRepository;


    public SuitResponse addSuit(SuitRequest suit){
        if(suitRepository.existsById(suit.getSuitId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this suit already exist");
        }
        Suit newSuit = SuitRequest.getSuitEntity(suit);
        suitRepository.save(newSuit);

        return new SuitResponse(newSuit);
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


    public void addCardToSuit(Card card, int suitId) {
        Suit suit = suitRepository.findById(suitId)
                .orElseThrow(() -> new EntityNotFoundException("Suit not found"));

        suit.addCard(card);
        suitRepository.save(suit);
    }

}

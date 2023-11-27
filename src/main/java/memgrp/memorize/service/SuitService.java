package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.SuitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SuitService {

    @Autowired
    private SuitRepository suitRepository;

    public void addCardToSuit(Card card, int suitId) {
        Suit suit = suitRepository.findById(suitId)
                .orElseThrow(() -> new EntityNotFoundException("Suit not found"));

        suit.addCard(card);
        suitRepository.save(suit);
    }



}

package memgrp.memorize.service;

import memgrp.memorize.dto.CardResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public List<CardResponse> getCards() {
        List<Card> cards = cardRepository.findAll();
        List<CardResponse> response = cards.stream().map((card -> new CardResponse(card))).toList();
        return response;
    }

    public Card addNewCard(Card card){
        return cardRepository.save(card);

    }












}

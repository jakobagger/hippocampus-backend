package memgrp.memorize.api;


import memgrp.memorize.dto.CardResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.service.CardService;
import memgrp.memorize.service.MatrixService;
import memgrp.memorize.service.SuitService;
import memgrp.memorize.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/card")
public class CardController {

    CardService cardService;

    ValueService valueService;

    SuitService suitService;

    MatrixService matrixService;

    public CardController(CardService cardService, ValueService valueService, SuitService suitService) {
        this.cardService = cardService;
        this.valueService = valueService;
        this.suitService = suitService;
    }

    @GetMapping
    public List<CardResponse> getCards() {
        List<CardResponse> cards = cardService.getCards();
        return cards;

    }

    @PostMapping("/matrix/{matrixId}")
    public ResponseEntity<String> addCardToMatrix(@RequestBody Card card, @PathVariable int matrixId) {
        matrixService.addCardToMatrix(card, matrixId);
        return ResponseEntity.ok("Card added to Matrix successfully");
    }

    @PostMapping("/value/{valueId}")
    public ResponseEntity<String> addCardToValue(@RequestBody Card card, @PathVariable int valueId) {
        valueService.addCardToValue(card, valueId);
        return ResponseEntity.ok("Card added to Value successfully");
    }

    @PostMapping("/suit/{suitId}")
    public ResponseEntity<String> addCardToSuit(@RequestBody Card card, @PathVariable int suitId) {
        suitService.addCardToSuit(card, suitId);
        return ResponseEntity.ok("Card added to Suit successfully");
    }










}

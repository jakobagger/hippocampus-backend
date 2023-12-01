package memgrp.memorize.api;


import memgrp.memorize.dto.CardResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.service.CardService;
import memgrp.memorize.service.MatrixService;
import memgrp.memorize.service.SuitService;
import memgrp.memorize.service.ValueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/card")
public class CardController {

    CardService cardService;
    ValueService valueService;
    SuitService suitService;
    MatrixService matrixService;

    public CardController(CardService cardService, ValueService valueService, SuitService suitService, MatrixService matrixService) {
        this.cardService = cardService;
        this.valueService = valueService;
        this.suitService = suitService;
        this.matrixService = matrixService;
    }

    @GetMapping
    public List<CardResponse> getCards() {
        List<CardResponse> cards = cardService.getCards();
        return cards;

    }

    @PostMapping("/add")
    public ResponseEntity<Card> addNewCard(@RequestBody Card card) {
        // Save the card entity (assuming you have a cardService)
        Card addedCard = cardService.addNewCard(card);
        return ResponseEntity.ok(addedCard);
    }

}

package memgrp.memorize.api;


import memgrp.memorize.dto.CardResponse;
import memgrp.memorize.service.CardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/card")
public class CardController {

    CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<CardResponse> getCards() {
        List<CardResponse> cards = cardService.getCards();
        return cards;

    }

}

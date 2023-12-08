package memgrp.memorize.service;

import memgrp.memorize.dto.CardResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.CardRepository;
import memgrp.memorize.repository.SuitRepository;
import memgrp.memorize.repository.ValueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CardServiceTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService;

    @Mock
    ValueRepository valueRepository;

    @Mock
    SuitRepository suitRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        Value v1 = new Value("Ace", "Sports Athlete");
        Value v2 = new Value("Queen", "Top Celebrity");
        Suit s1 = new Suit("Hearts", "Kind");
        Suit s2 = new Suit("Clubs", "Cool");
        Card c1 = new Card(v1, s1, "Arnold Schwarzenegger", "Bench press", "Barbell", "image1");
        Card c2 = new Card(v2, s2, "Beyonce", "Power dances on", "Beach", "image2");

        when(cardRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
    }

    @Test
    void getCards() {
        List<CardResponse> cards = cardService.getCards();
        assertEquals(2, cards.size());
        verify(cardRepository).findAll();
    }
}

package memgrp.memorize.service;

import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.SuitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SuitServiceTest {

    @Autowired
    SuitRepository suitRepository;

    @Autowired
    MatrixRepository matrixRepository;

    SuitService suitService;

    boolean isInitialized;
    Suit suit1, suit2;
    @BeforeEach
    void setUp() {
        if(!isInitialized)
            suitRepository.deleteAll();
            suit1 = suitRepository.save(new Suit("Hearts", "Loving"));
            suit2 = suitRepository.save(new Suit("Spades", "Gambling"));
            suitService = new SuitService(suitRepository,matrixRepository);
            isInitialized = true;
    }

    @Test
    void getSuits(){
        List<SuitResponse> suitResponses = suitService.getSuit();
        assertEquals(2, suitResponses.size());
    }
}
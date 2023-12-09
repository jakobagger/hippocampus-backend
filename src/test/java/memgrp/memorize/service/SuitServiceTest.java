package memgrp.memorize.service;

import memgrp.memorize.dto.SuitRequest;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.entity.Card;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Member;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.MemberRepository;
import memgrp.memorize.repository.SuitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SuitServiceTest {

    @Mock
    private SuitRepository suitRepository;

    @InjectMocks
    private SuitService suitService;

    @BeforeEach
    public void setUp() {
        Suit s1 = new Suit();
        Suit s2 = new Suit();

        s1.setSuitName("Hearts");
        s2.setSuitDescription("Good");


        when(suitRepository.findAll()).thenReturn(Arrays.asList(s1,s2));

    }
    @Test
    public void testGetSuit() {
    List<SuitResponse> suits = suitService.getSuit();
    assertEquals(2, suits.size());
    assertEquals("Hearts", suits.get(0).getSuitName());
    assertEquals("Good", suits.get(1).getSuitDescription());
    assertEquals(0, suits.get(0).getSuitId());
    }

    @Test
    public void testAddSuit() {


    }




}
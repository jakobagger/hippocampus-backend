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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


public class SuitServiceTest {

    @Mock
    private SuitRepository suitRepository;

    @InjectMocks
    private SuitService suitService;

    @BeforeEach
    public void setUp() {
        Suit s1 = new Suit();
        Suit s2 = new Suit();
        Matrix m1 = new Matrix(1, "TestMatrix");



    }

    @Test
    public void testAddSuit() {


    }

    @Test
    public void testGetSuit() {

    }


}
package memgrp.memorize.service;

import memgrp.memorize.dto.SuitResponse;
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

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


class SuitServiceTest {

    @Mock
    SuitRepository suitRepository;

    @InjectMocks
    SuitService suitService;

    @Mock
    MatrixRepository matrixRepository;
    @Mock
    MemberRepository memberRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        Member m1 = new Member("username", "email", "password");
        Matrix mat1 = new Matrix(1, "Test1");
        Suit s1 = new Suit("Hearts", "sweet");

        when(SuitRepository.findAll()).thenReturn(Arrays.asList(s1));
    }

}
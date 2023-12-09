package memgrp.memorize.service;

import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.MatrixRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatrixServiceTest {

    @Mock
    MatrixRepository matrixRepository;

    @InjectMocks
    MatrixService matrixService;

    Matrix m1;
    Matrix m2;

    @BeforeEach
    void setup() {
        m1 = new Matrix(1,"Default");
        m2 = new Matrix();
        Suit s1 = new Suit("Clubs", "Cool");
        Value v1 = new Value("Ace", "Sports Athlete");
        m2.addSuits(s1);
        m1.addValue(v1);
    }
    @Test
    void getMatrix() {
        when(matrixRepository.findAll()).thenReturn(Arrays.asList(m1,m2));
        List<MatrixResponse> matrixList = matrixService.getMatrix();
        assertEquals(2, matrixList.size());
        assertEquals("Clubs",matrixList.get(1).getSuits().get(0).getSuitName());
        assertEquals("Ace",matrixList.get(0).getValues().get(0).getValueName());
        assertEquals("Default", matrixList.get(0).getMatrixName());
        verify(matrixRepository).findAll();
    }

    @Test
    void getDefaultMatrix() {
        when(matrixRepository.findById(1)).thenReturn(Optional.of(m1));
        MatrixResponse response = matrixService.getDefaultMatrix();
        assertEquals(1, response.getMatrixId());
        verify(matrixRepository).findById(1);
    }

}
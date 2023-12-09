package memgrp.memorize.service;

import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.MatrixRequest;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.entity.Card;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
    @Test
    void testAddMatrix_Success() {
        int matrixId = 1;
        String matrixName = "Mock Matrix";
        MatrixRequest mockRequest = new MatrixRequest(matrixId, matrixName);

        Matrix mockMatrix = new Matrix(matrixId, matrixName);
        when(matrixRepository.existsById(matrixId)).thenReturn(false);
        when(matrixRepository.save(any(Matrix.class))).thenReturn(mockMatrix);

        MatrixResponse response = matrixService.addMatrix(mockRequest);

        assertNotNull(response);
        assertEquals(matrixId, response.getMatrixId());
    }
    @Test
    void testAddMatrix_MatrixExists() {
        int matrixId = 1;
        String matrixName = "Mock Matrix";
        MatrixRequest mockRequest = new MatrixRequest(matrixId, matrixName);

        when(matrixRepository.existsById(matrixId)).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> {
            matrixService.addMatrix(mockRequest);
        });
    }
    @Test
    void testAddCardToMatrix_Success() {
        Value mockValue = new Value("Ace", "Sports Athlete");
        Suit mockSuit = new Suit("Clubs", "Cool");
        String person = "Mock Person";
        String action = "Mock Action";
        String object = "Mock Object";
        String base64 = "Mock Base64String";

        Card mockCard = new Card(mockValue, mockSuit, person, action, object, base64);
        int matrixId = 1;
        Matrix mockMatrix = new Matrix(matrixId, "Ikke Default");
        when(matrixRepository.findById(matrixId)).thenReturn(Optional.of(mockMatrix));

        matrixService.addCardToMatrix(mockCard, matrixId);

        verify(matrixRepository).findById(matrixId);
        verify(matrixRepository).save(mockMatrix);
        assertTrue(mockMatrix.getCards().contains(mockCard));
    }
    @Test
    void testAddCardToMatrix_MatrixNotFound() {
        Value mockValue = new Value("Ace", "Sports Athlete");
        Suit mockSuit = new Suit("Clubs", "Cool");
        String person = "Mock Person";
        String action = "Mock Action";
        String object = "Mock Object";
        String base64 = "Mock Base64String";

        Card mockCard = new Card(mockValue, mockSuit, person, action, object, base64);
        int matrixId = 1;
        when(matrixRepository.findById(matrixId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            matrixService.addCardToMatrix(mockCard, matrixId);
        });
    }
}
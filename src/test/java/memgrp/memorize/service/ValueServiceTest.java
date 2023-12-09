package memgrp.memorize.service;

import memgrp.memorize.dto.ValueRequest;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.ValueRepository;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValueServiceTest {

    @Mock
    ValueRepository valueRepository;
    @Mock
    MatrixRepository matrixRepository;

    @InjectMocks
    ValueService valueService;

    @Test
    public void testGetValue(){
        Value v1 = new Value();
        Value v2 = new Value();

        v1.setValueName("Ace");
        v2.setValueDescription("Caring");

        when(valueRepository.findAll()).thenReturn(Arrays.asList(v1,v2));

        List<ValueResponse> values = valueService.getValue();
        assertEquals(2, values.size());
        assertEquals("Ace", values.get(0).getValueName());
        assertEquals("Caring", values.get(1).getValueDescription());
        assertEquals(0, values.get(1).getValueId());
    }

    @Test
    public void testAddValue(){
        when(valueRepository.existsById(anyInt())).thenReturn(false);

        ValueRequest valueRequest = new ValueRequest("Hopeful", "Clubs");
        ValueResponse valueResponse = valueService.addValue(valueRequest);
        assertEquals("Clubs", valueResponse.getValueName());
        assertEquals("Hopeful", valueResponse.getValueDescription());
    }
}
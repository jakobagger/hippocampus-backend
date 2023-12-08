package memgrp.memorize.api;


import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.SuitRequest;
import memgrp.memorize.dto.ValueRequest;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Value;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.ValueRepository;
import memgrp.memorize.service.ValueService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/value")
public class ValueController {

    ValueService valueService;
    MatrixRepository matrixRepository;
    ValueRepository valueRepository;

    public ValueController(ValueService valueService, MatrixRepository matrixRepository, ValueRepository valueRepository) {
        this.valueService = valueService;
        this.matrixRepository = matrixRepository;
        this.valueRepository = valueRepository;
    }

    @GetMapping()
    public List<ValueResponse> getValues() {
        return valueService.getValue();
    }

    @PostMapping()
    ValueResponse addValue(@RequestBody ValueRequest body) {
        return valueService.addValue(body);
    }

//    @PostMapping()
//    List<ValueResponse> addValues(@RequestBody List<ValueRequest> body) {
//        List<ValueResponse> responses = new ArrayList<>();
//        for (ValueRequest value : body) {
//            Value newValue = ValueRequest.getValueEntity(value);
//            Matrix matrix = matrixRepository.findById(value.getMatrixId()).orElseThrow(() -> new EntityNotFoundException("Matrix not found"));
//            newValue.setMatrix(matrix);
//            valueRepository.save(newValue);
//            responses.add(new ValueResponse(newValue));
//        }
//        return responses;
//    }

}
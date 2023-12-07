package memgrp.memorize.api;

import memgrp.memorize.dto.MatrixRequest;
import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.service.MatrixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/matrix")
public class MatrixController {

    MatrixService matrixService;

    public MatrixController(MatrixService matrixService){
        this.matrixService = matrixService;
    }

    @GetMapping()
    public List<MatrixResponse> getMatrix(){
        return matrixService.getMatrix();
    }

    @GetMapping("/default")
    public MatrixResponse getDefaultMatrix() {
        return matrixService.getDefaultMatrix();
    }
    @PostMapping
    MatrixResponse addMatrix(@RequestBody MatrixRequest body) {
        return matrixService.addMatrix(body);
    }
}

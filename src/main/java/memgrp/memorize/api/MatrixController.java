package memgrp.memorize.api;

import memgrp.memorize.dto.MatrixResponse;
import memgrp.memorize.service.MatrixService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

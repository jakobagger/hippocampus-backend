package memgrp.memorize.api;


import jakarta.persistence.EntityNotFoundException;
import memgrp.memorize.dto.SuitRequest;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.entity.Matrix;
import memgrp.memorize.entity.Suit;
import memgrp.memorize.repository.MatrixRepository;
import memgrp.memorize.repository.SuitRepository;
import memgrp.memorize.service.SuitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/suit")
public class SuitController {

    SuitService suitService;
    MatrixRepository matrixRepository;
    SuitRepository suitRepository;

    public SuitController(SuitService suitService, MatrixRepository matrixRepository, SuitRepository suitRepository){
        this.suitService = suitService;
        this.matrixRepository = matrixRepository;
        this.suitRepository = suitRepository;
    }

    @GetMapping()
    public List<SuitResponse> getSuits(){
        return suitService.getSuit();
    }

    @PostMapping()
    SuitResponse addSuit(@RequestBody SuitRequest body){
        return suitService.addSuit(body);
    }
//    @PostMapping()
//    List<SuitResponse> addSuits(@RequestBody List<SuitRequest> body){
//        List<SuitResponse> responses = new ArrayList<>();
//        for (SuitRequest suit : body) {
//            Suit newSuit = SuitRequest.getSuitEntity(suit);
//            Matrix matrix = matrixRepository.findById(suit.getMatrixId()).orElseThrow(() -> new EntityNotFoundException("Matrix not found"));
//            newSuit.setMatrix(matrix);
//            suitRepository.save(newSuit);
//            responses.add(new SuitResponse(newSuit));
//        }
//        return responses;
//    }
}

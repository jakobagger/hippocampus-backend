package memgrp.memorize.api;


import memgrp.memorize.dto.SuitRequest;
import memgrp.memorize.dto.SuitResponse;
import memgrp.memorize.service.SuitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/suit")
public class SuitController {

    SuitService suitService;

    public SuitController(SuitService suitService){
        this.suitService = suitService;
    }
    @GetMapping()
    public List<SuitResponse> getSuits(){
        return suitService.getSuit();
    }

    @PostMapping()
    SuitResponse addSuit(@RequestBody SuitRequest body){
        return suitService.addSuit(body);
    }

}

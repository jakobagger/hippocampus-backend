package memgrp.memorize.api;


import memgrp.memorize.dto.ValueRequest;
import memgrp.memorize.dto.ValueResponse;
import memgrp.memorize.service.ValueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/value")
public class ValueController {

    ValueService valueService;

    public ValueController(ValueService valueService){
        this.valueService = valueService;
    }

    @GetMapping()
    public List<ValueResponse> getValues(){
        return valueService.getValue();
    }

    @PostMapping()
    ValueResponse addValue(@RequestBody ValueRequest body){
        return valueService.addValue(body);
    }
}

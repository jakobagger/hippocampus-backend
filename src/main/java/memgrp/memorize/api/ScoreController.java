package memgrp.memorize.api;


import memgrp.memorize.dto.ScoreRequest;
import memgrp.memorize.service.ScoreService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/score")
public class ScoreController {

    ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping()
    public void addScoreToQuizWithUsername(@RequestBody ScoreRequest body) {
        scoreService.addScoreToQuizWithUsername(body);
    }
}

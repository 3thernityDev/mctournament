
package re.ethernitydev.mctournament.controller.api;

import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.Score;
import re.ethernitydev.mctournament.service.ScoreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }
}

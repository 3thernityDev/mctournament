
package re.ethernitydev.mctournament.service;

import org.springframework.stereotype.Service;
import re.ethernitydev.mctournament.model.Score;
import re.ethernitydev.mctournament.repository.ScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScoreById(Long id) {
        return scoreRepository.findById(id);
    }

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}

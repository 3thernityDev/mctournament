package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}

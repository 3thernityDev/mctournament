package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.Match;

interface MatchRepository extends JpaRepository<Match, Long> {
}

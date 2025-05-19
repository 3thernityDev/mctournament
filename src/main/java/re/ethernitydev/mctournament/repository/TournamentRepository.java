package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}

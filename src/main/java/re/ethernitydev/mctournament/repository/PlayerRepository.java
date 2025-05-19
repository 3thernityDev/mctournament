package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

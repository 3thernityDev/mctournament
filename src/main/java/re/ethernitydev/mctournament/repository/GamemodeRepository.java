package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.Gamemode;

interface GamemodeRepository extends JpaRepository<Gamemode, Long> {
}

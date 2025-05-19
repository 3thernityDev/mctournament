package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.MinecraftGame;

public interface MinecraftGameRepository extends JpaRepository<MinecraftGame, Long> {
}

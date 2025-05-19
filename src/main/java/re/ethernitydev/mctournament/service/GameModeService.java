package re.ethernitydev.mctournament.service;

import org.springframework.stereotype.Service;
import re.ethernitydev.mctournament.model.Gamemode;
import re.ethernitydev.mctournament.repository.GamemodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameModeService {

    private final GamemodeRepository gameModeRepository;

    public GameModeService(GamemodeRepository gameModeRepository) {
        this.gameModeRepository = gameModeRepository;
    }

    public Gamemode createGameMode(Gamemode gameMode) {
        return gameModeRepository.save(gameMode);
    }

    public List<Gamemode> getAllGameModes() {
        return gameModeRepository.findAll();
    }

    public Optional<Gamemode> getGameModeById(Long id) {
        return gameModeRepository.findById(id);
    }

    public void deleteGameMode(Long id) {
        gameModeRepository.deleteById(id);
    }
}

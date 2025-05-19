package re.ethernitydev.mctournament.service;

import org.springframework.stereotype.Service;
import re.ethernitydev.mctournament.model.MinecraftGame;
import re.ethernitydev.mctournament.repository.MinecraftGameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MinecraftGameService {

    private final MinecraftGameRepository gameRepository;

    public MinecraftGameService(MinecraftGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public MinecraftGame createGame(MinecraftGame game) {
        return gameRepository.save(game);
    }

    public List<MinecraftGame> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<MinecraftGame> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}

package re.ethernitydev.mctournament.controller.api;

import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.MinecraftGame;
import re.ethernitydev.mctournament.service.MinecraftGameService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class MinecraftGameController {

    private final MinecraftGameService gameService;

    public MinecraftGameController(MinecraftGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public MinecraftGame createGame(@RequestBody MinecraftGame game) {
        return gameService.createGame(game);
    }

    @GetMapping
    public List<MinecraftGame> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Optional<MinecraftGame> getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}

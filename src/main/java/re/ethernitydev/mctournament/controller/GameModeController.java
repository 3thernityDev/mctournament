package re.ethernitydev.mctournament.controller;

import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.Gamemode;
import re.ethernitydev.mctournament.service.GameModeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gamemodes")
public class GameModeController {

    private final GameModeService gameModeService;

    public GameModeController(GameModeService gameModeService) {
        this.gameModeService = gameModeService;
    }

    @PostMapping
    public Gamemode createGameMode(@RequestBody Gamemode gameMode) {
        return gameModeService.createGameMode(gameMode);
    }

    @GetMapping
    public List<Gamemode> getAllGameModes() {
        return gameModeService.getAllGameModes();
    }

    @GetMapping("/{id}")
    public Optional<Gamemode> getGameModeById(@PathVariable Long id) {
        return gameModeService.getGameModeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameMode(@PathVariable Long id) {
        gameModeService.deleteGameMode(id);
    }
}

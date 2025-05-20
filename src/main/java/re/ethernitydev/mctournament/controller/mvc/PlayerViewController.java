package re.ethernitydev.mctournament.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.Player;
import re.ethernitydev.mctournament.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerViewController {

    private final PlayerService playerService;

    public PlayerViewController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public String showPlayerDetails(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable avec ID : " + id));

        model.addAttribute("player", player);
        return "players/details";
    }
}

package re.ethernitydev.mctournament.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.SingleEliminationTournament;
import re.ethernitydev.mctournament.model.TournamentType;
import re.ethernitydev.mctournament.service.GameModeService;
import re.ethernitydev.mctournament.service.MinecraftGameService;
import re.ethernitydev.mctournament.service.TournamentService;

@Controller
@RequestMapping("/tournaments")
public class TournamentControllerMVC {

    private final TournamentService tournamentService;
    private final MinecraftGameService gameService;
    private final GameModeService gameModeService;

    public TournamentControllerMVC(TournamentService tournamentService, 
                                 MinecraftGameService gameService, 
                                 GameModeService gameModeService) {
        this.tournamentService = tournamentService;
        this.gameService = gameService;
        this.gameModeService = gameModeService;
    }

    @GetMapping
    public String getAllTournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        return "tournaments/TournamentListPage";
    }

    @GetMapping("/{id}")
    public String getTournamentById(@PathVariable Long id, Model model) {
        var tournament = tournamentService.getTournamentById(id);
        if (tournament.isEmpty()) {
            return "redirect:/tournaments";
        }
        model.addAttribute("tournament", tournament.get());
        return "tournaments/TournamentDetailsPage";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("tournament", new SingleEliminationTournament());
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("gameModes", gameModeService.getAllGameModes());
        model.addAttribute("tournamentTypes", TournamentType.values());
        return "tournaments/TournamentCreationForm";
    }

    @PostMapping
    public String createTournament(@ModelAttribute SingleEliminationTournament tournament) {
        tournamentService.createTournament(tournament);
        return "redirect:/tournaments";
    }

    @GetMapping("/{id}/delete")
    public String deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return "redirect:/tournaments";
    }
}
package re.ethernitydev.mctournament.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.Tournament;
import re.ethernitydev.mctournament.service.TournamentService;

@Controller
@RequestMapping("/tournaments")
public class TournamentViewController {

    private final TournamentService tournamentService;

    public TournamentViewController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping("/{id}")
    public String showTournamentDetails(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentService.getTournamentById(id)
                .orElseThrow(() -> new RuntimeException("Tournoi introuvable avec ID : " + id));

        model.addAttribute("tournament", tournament);
        return "tournaments/details";
    }
}

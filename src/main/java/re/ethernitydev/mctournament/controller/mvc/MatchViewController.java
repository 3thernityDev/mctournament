package re.ethernitydev.mctournament.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.ethernitydev.mctournament.model.Match;
import re.ethernitydev.mctournament.service.MatchService;

@Controller
@RequestMapping("/matches")
public class MatchViewController {

    private final MatchService matchService;

    public MatchViewController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public String showMatchDetails(@PathVariable Long id, Model model) {
        Match match = matchService.getMatchById(id)
                .orElseThrow(() -> new RuntimeException("Match introuvable avec ID : " + id));

        model.addAttribute("match", match);
        return "matches/details";
    }
}

package re.ethernitydev.mctournament.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerMVC {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Accueil - MC Tournament");
        model.addAttribute("activeTab", "home");
        return "home";
    }
}
package re.ethernitydev.mctournament.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import re.ethernitydev.mctournament.model.Player;
import re.ethernitydev.mctournament.model.UserRole;
import re.ethernitydev.mctournament.repository.PlayerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Player createPlayer(Player player) {
        // Sécurise le mot de passe
        player.setPassword(passwordEncoder.encode(player.getPassword()));

        // Renseigne date et rôle
        player.setRegistrationDate(LocalDateTime.now());
        player.setRole(UserRole.PLAYER);

        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

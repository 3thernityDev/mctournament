package re.ethernitydev.mctournament.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import re.ethernitydev.mctournament.model.*;
import re.ethernitydev.mctournament.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;
    private final MinecraftGameRepository gameRepository;
    private final GamemodeRepository gamemodeRepository;
    private final TournamentRepository tournamentRepository;

    public DataInitializer(
            UserRepository userRepository,
            PlayerRepository playerRepository,
            MinecraftGameRepository gameRepository,
            GamemodeRepository gamemodeRepository,
            TournamentRepository tournamentRepository
    ) {
        this.userRepository = userRepository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.gamemodeRepository = gamemodeRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @PostConstruct
    public void init() {
        // --- Create a few GameModes ---
        Gamemode solo = new Gamemode();
        solo.setName("Solo");
        solo.setDescription("1v1 Mode");
        solo.setMinPlayers(2);
        solo.setMaxPlayers(2);
        solo.setScoreToWin(1);

        Gamemode team = new Gamemode();
        team.setName("Team Battle");
        team.setDescription("2v2 Mode");
        team.setMinPlayers(4);
        team.setMaxPlayers(4);
        team.setScoreToWin(3);

        // Save the gamemodes first and get the managed entities back
        solo = gamemodeRepository.save(solo);
        team = gamemodeRepository.save(team);

        // --- Create MinecraftGame ---
        MinecraftGame game = new MinecraftGame();
        game.setName("Skywars");
        game.setDescription("Battle on sky islands");
        game.setFormat(GameFormat.ELIMINATION);
        game.setAverageMatchDuration(10);
        game.setAvailableModes(List.of(solo, team)); // Now using managed entities
        gameRepository.save(game);

        // --- Create Users and Players ---
        for (int i = 1; i <= 4; i++) {
            Player player = new Player();
            player.setUsername("player" + i);
            player.setEmail("player" + i + "@mail.com");
            player.setPassword("password");
            player.setNickname("P" + i);
            player.setMinecraftUuid("uuid-" + i);
            player.setEloRating(1000 + i * 10);
            player.setRegistrationDate(LocalDateTime.now());
            player.setRole(UserRole.PLAYER);
            playerRepository.save(player);
        }

        // --- Create a Tournament ---
        SingleEliminationTournament tournament = new SingleEliminationTournament();
        tournament.setName("Skywars Cup");
        tournament.setDescription("Ultimate 1v1 showdown");
        tournament.setGame(game);
        tournament.setGamemode(solo);
        tournament.setStartDate(LocalDateTime.now().plusDays(1));
        tournament.setEndDate(LocalDateTime.now().plusDays(3));
        tournament.setMaxParticipants(8);
        tournament.setStatus(TournamentStatus.UPCOMING);
        tournament.setHasThirdPlaceMatch(true);

        tournamentRepository.save(tournament);
    }
}

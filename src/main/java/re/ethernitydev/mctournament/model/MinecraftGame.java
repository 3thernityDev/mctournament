package re.ethernitydev.mctournament.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "minecraft_games")
public class MinecraftGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private GameFormat format;

    private int averageMatchDuration;

    @OneToMany
    @JoinColumn(name = "game_id")
    private List<Gamemode> availableModes = new ArrayList<>();

    public MinecraftGame() {
    }

    public MinecraftGame(String name, String description, GameFormat format, int averageMatchDuration) {
        this.name = name;
        this.description = description;
        this.format = format;
        this.averageMatchDuration = averageMatchDuration;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameFormat getFormat() {
        return format;
    }

    public void setFormat(GameFormat format) {
        this.format = format;
    }

    public int getAverageMatchDuration() {
        return averageMatchDuration;
    }

    public void setAverageMatchDuration(int averageMatchDuration) {
        this.averageMatchDuration = averageMatchDuration;
    }

    public List<Gamemode> getAvailableModes() {
        return availableModes;
    }

    public void setAvailableModes(List<Gamemode> availableModes) {
        this.availableModes = availableModes;
    }

    public void addGameMode(Gamemode gamemode) {
        this.availableModes.add(gamemode);
    }

    public Gamemode getGameModeById(Long gameModeId) {
        return this.availableModes.stream()
                .filter(mode -> mode.getId().equals(gameModeId))
                .findFirst()
                .orElse(null);
    }
}
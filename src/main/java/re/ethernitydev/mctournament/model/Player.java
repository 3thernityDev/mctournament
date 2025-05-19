package re.ethernitydev.mctournament.model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "players")
@PrimaryKeyJoinColumn(name = "user_id")
public class Player extends User {

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String minecraftUuid;

    private Integer eloRating = 1000;

    @ElementCollection
    @CollectionTable(name = "player_statistics",
            joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyJoinColumn(name = "game_id")
    private Map<MinecraftGame, PlayerStats> statistics = new HashMap<>();

    public Player() {
        super();
        this.setRole(UserRole.PLAYER);
    }

    // Getters & Setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMinecraftUuid() {
        return minecraftUuid;
    }

    public void setMinecraftUuid(String minecraftUuid) {
        this.minecraftUuid = minecraftUuid;
    }

    public Integer getEloRating() {
        return eloRating;
    }

    public void setEloRating(Integer eloRating) {
        this.eloRating = eloRating;
    }

    public Map<MinecraftGame, PlayerStats> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<MinecraftGame, PlayerStats> statistics) {
        this.statistics = statistics;
    }

    public void addStatistic(MinecraftGame game, PlayerStats stats) {
        this.statistics.put(game, stats);
    }

    public PlayerStats getStatisticForGame(MinecraftGame game) {
        return this.statistics.get(game);
    }
}
package re.ethernitydev.mctournament.model;

import jakarta.persistence.*;
import java.util.Map;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clé = joueur, Valeur = score
    @ElementCollection
    @CollectionTable(name = "score_values", joinColumns = @JoinColumn(name = "score_id"))
    @MapKeyJoinColumn(name = "player_id")
    @Column(name = "score")
    private Map<Player, Integer> playerScores;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    private boolean forfeit;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Player, Integer> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Map<Player, Integer> playerScores) {
        this.playerScores = playerScores;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isForfeit() {
        return forfeit;
    }

    public void setForfeit(boolean forfeit) {
        this.forfeit = forfeit;
    }
}

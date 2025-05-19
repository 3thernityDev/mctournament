package re.ethernitydev.mctournament.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlayerStats {

    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private double winRate = 0.0;
    private int eloRating = 1000;

    public PlayerStats() {
    }

    public PlayerStats(int wins, int losses, int draws) {
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        calculateWinRate();
    }

    // Getters & Setters
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        calculateWinRate();
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
        calculateWinRate();
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        calculateWinRate();
    }

    public double getWinRate() {
        return winRate;
    }

    public int getEloRating() {
        return eloRating;
    }

    public void setEloRating(int eloRating) {
        this.eloRating = eloRating;
    }

    private void calculateWinRate() {
        int totalMatches = wins + losses + draws;
        if (totalMatches > 0) {
            winRate = (double) wins / totalMatches;
        } else {
            winRate = 0.0;
        }
    }

    public void updateAfterMatch(boolean won, boolean draw, int eloChange) {
        if (draw) {
            draws++;
        } else if (won) {
            wins++;
        } else {
            losses++;
        }

        eloRating += eloChange;
        calculateWinRate();
    }
}
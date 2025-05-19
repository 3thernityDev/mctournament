package re.ethernitydev.mctournament.model;

import jakarta.persistence.Entity;

@Entity
public class RoundRobinTournament extends Tournament {

    private int numberOfRounds;
    private boolean homeAndAway;

    @Override
    public void generateBracket() {
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public boolean isHomeAndAway() {
        return homeAndAway;
    }

    public void setHomeAndAway(boolean homeAndAway) {
        this.homeAndAway = homeAndAway;
    }
}

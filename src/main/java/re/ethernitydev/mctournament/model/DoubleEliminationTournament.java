package re.ethernitydev.mctournament.model;

import jakarta.persistence.Entity;

@Entity
public class DoubleEliminationTournament extends Tournament {

    private boolean hasConsolationFinal;

    @Override
    public void generateBracket() {
    }

    public boolean isHasConsolationFinal() {
        return hasConsolationFinal;
    }

    public void setHasConsolationFinal(boolean hasConsolationFinal) {
        this.hasConsolationFinal = hasConsolationFinal;
    }
}

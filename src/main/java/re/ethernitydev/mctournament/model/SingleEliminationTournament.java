package re.ethernitydev.mctournament.model;

import jakarta.persistence.Entity;

@Entity
public class SingleEliminationTournament extends Tournament {

    private boolean hasThirdPlaceMatch;

    @Override
    public void generateBracket() {
    }

    public boolean isHasThirdPlaceMatch() {
        return hasThirdPlaceMatch;
    }

    public void setHasThirdPlaceMatch(boolean hasThirdPlaceMatch) {
        this.hasThirdPlaceMatch = hasThirdPlaceMatch;
    }
}

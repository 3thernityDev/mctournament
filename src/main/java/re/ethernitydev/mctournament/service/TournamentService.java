package re.ethernitydev.mctournament.service;

import org.springframework.stereotype.Service;
import re.ethernitydev.mctournament.model.Tournament;
import re.ethernitydev.mctournament.repository.TournamentRepository;
import re.ethernitydev.mctournament.model.TournamentStatus;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public void createTournament(Tournament tournament) {
        tournament.setStatus(TournamentStatus.PENDING);
        tournamentRepository.save(tournament);
    }
}
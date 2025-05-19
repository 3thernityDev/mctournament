package re.ethernitydev.mctournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ethernitydev.mctournament.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}


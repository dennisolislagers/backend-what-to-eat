package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

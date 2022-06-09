package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllUsersByUsernameEqualsIgnoreCase(String username);
}

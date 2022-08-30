package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsletterRepository extends JpaRepository <Newsletter, Long> {
}

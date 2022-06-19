package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsletterRepository extends JpaRepository <Newsletter, Long> {
    List<Newsletter> findNewsletterByTitleEqualsIgnoreCase(String title);
}

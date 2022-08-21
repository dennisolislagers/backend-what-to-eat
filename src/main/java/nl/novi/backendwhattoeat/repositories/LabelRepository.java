package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository <Label, Long> {
}

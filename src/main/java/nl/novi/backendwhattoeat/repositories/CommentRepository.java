package nl.novi.backendwhattoeat.repositories;

import nl.novi.backendwhattoeat.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    Optional<Comment> findCommentByTitleEqualsIgnoreCase(String title);
}

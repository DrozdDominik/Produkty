package pl.dominikdrozd.Dodawanie_Produkt.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dominikdrozd.Dodawanie_Produkt.model.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}

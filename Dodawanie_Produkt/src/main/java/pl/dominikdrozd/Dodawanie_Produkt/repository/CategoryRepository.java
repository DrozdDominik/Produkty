package pl.dominikdrozd.Dodawanie_Produkt.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dominikdrozd.Dodawanie_Produkt.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}

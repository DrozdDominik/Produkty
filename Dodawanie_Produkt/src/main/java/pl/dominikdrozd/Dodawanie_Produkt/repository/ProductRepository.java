package pl.dominikdrozd.Dodawanie_Produkt.repository;

import org.springframework.data.repository.CrudRepository;
import pl.dominikdrozd.Dodawanie_Produkt.model.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
}

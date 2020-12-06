package com.esercizio.HybernateEs1.repos;
import com.esercizio.HybernateEs1.entities.Prodotto;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ProdottoRepo extends CrudRepository<Prodotto,Long> {
    Optional<Prodotto> findByNome(String nome);
}

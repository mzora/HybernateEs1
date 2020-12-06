package com.esercizio.HybernateEs1.repos;

import com.esercizio.HybernateEs1.entities.Vendita;
import org.springframework.data.repository.CrudRepository;

public interface VenditaRepo extends CrudRepository<Vendita,Long> {
}

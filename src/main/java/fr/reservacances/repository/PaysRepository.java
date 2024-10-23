package fr.reservacances.repository;

import fr.reservacances.model.localisation.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays, String> {

}

package fr.reservacances.repository.localisation;

import fr.reservacances.model.localisation.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, String> {

}

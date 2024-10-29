package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Avion;
import fr.reservacances.model.vol.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, String> {
    
}

package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, String> {
    
}

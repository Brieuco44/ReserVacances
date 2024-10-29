package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.model.vol.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportRepository extends JpaRepository<Aeroport, String> {
    
}

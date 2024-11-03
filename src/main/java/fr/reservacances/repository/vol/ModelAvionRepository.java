package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.ModeleAvion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelAvionRepository extends JpaRepository<ModeleAvion, String> {
    
}

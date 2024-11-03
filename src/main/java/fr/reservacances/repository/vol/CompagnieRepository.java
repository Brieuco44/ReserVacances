package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Compagnie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompagnieRepository extends JpaRepository<Compagnie, String> {
    
}

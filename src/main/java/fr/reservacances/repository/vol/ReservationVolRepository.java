package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.model.vol.ReservationVol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationVolRepository extends JpaRepository<ReservationVol, String> {
    
}

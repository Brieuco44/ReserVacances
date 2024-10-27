package fr.reservacances.repository.voiture;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.voiture.ReservationVoiture;

public interface ReservationVoitureRepository extends JpaRepository<ReservationVoiture, String>{
    
}

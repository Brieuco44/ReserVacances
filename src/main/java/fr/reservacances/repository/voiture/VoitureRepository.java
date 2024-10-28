package fr.reservacances.repository.voiture;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.reservacances.model.voiture.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
    @Query("SELECT v FROM Voiture v WHERE NOT EXISTS (" +
           "SELECT r FROM ReservationVoiture r WHERE r.voiture = v " +
           "AND r.dateDebut <= :dateFin AND r.dateFin >= :dateDebut)")
    List<Voiture> findAvailableVoitures(@Param("dateDebut") LocalDateTime dateDebut, 
                                         @Param("dateFin") LocalDateTime dateFin);
}

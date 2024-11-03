package fr.reservacances.repository.hotel;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.reservacances.model.hotel.ReservationHotel;

@Repository
public interface ReservationHotelRepository extends JpaRepository<ReservationHotel, String> {
        @Query("SELECT COUNT(r) = 0 FROM ReservationHotel r " +
                        "WHERE r.chambre.id = :chambreId " +
                        "AND (r.dateDebut < :dateFin AND r.dateFin > :dateDebut)")
        boolean isChambreDisponible(@Param("chambreId") String chambreId,
                        @Param("dateDebut") LocalDateTime dateDebut,
                        @Param("dateFin") LocalDateTime dateFin);
}

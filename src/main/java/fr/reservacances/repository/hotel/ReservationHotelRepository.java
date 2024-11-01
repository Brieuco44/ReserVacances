package fr.reservacances.repository.hotel;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.reservacances.model.hotel.ReservationHotel;

public interface ReservationHotelRepository extends JpaRepository<ReservationHotel, String> {
    public List<ReservationHotel> findByHotelId(String hotelId);

    @Query("SELECT r FROM Reservation r WHERE r.chambre.id = :chambreId " +
            "AND r.dateDebut < :dateFin " +
            "AND r.dateFin > :dateDebut")
    List<ReservationHotel> findReservationsByChambreAndDate(
            @Param("chambreId") String chambreId,
            @Param("dateDebut") LocalDateTime dateDebut,
            @Param("dateFin") LocalDateTime dateFin);
}
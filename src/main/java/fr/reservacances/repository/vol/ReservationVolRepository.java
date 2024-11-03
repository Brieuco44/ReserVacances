package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.ReservationVol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationVolRepository extends JpaRepository<ReservationVol, String> {
    @Query("SELECT SUM(r.nbAdulte + r.nbEnfant) FROM ReservationVol r WHERE r.vol.id = :volId")
    Integer getTotalPlacesByVolId(@Param("volId") String volId);
}

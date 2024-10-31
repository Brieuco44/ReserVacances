package fr.reservacances.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, String> {
    public List<Chambre> findAllByHotelId(String hotelId);

}

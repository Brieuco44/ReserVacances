package fr.reservacances.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    public List<Hotel> findAllByVilleId(String villeId);
}

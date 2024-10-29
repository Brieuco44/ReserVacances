package fr.reservacances.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.ReservationHotel;

public interface ReservationHotelRepository extends JpaRepository<ReservationHotel, String>{
    public List<ReservationHotel> findByHotelId(String hotelId);
}

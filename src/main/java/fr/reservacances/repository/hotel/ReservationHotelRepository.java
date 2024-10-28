package fr.reservacances.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.ReservationHotel;

public interface ReservationHotelRepository extends JpaRepository<ReservationHotel, String>{

}

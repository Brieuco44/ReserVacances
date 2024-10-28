package fr.reservacances.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}

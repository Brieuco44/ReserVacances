package fr.reservacances.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.hotel.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, String>{


}

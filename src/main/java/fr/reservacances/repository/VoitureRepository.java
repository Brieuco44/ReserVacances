package fr.reservacances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.voiture.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
}

package fr.reservacances.repository.voiture;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.voiture.Marque;

public interface MarqueRepository extends JpaRepository<Marque, String> {
    
}

package fr.reservacances.repository.voiture;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.voiture.ModeleVoiture;

public interface ModeleVoitureRepository extends JpaRepository<ModeleVoiture, String>{
    // public Optional<Marque>findByMarque(String )
}

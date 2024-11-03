package fr.reservacances.repository.vol;

import fr.reservacances.model.vol.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VolRepository extends JpaRepository<Vol, String> {

    Optional<List<Vol>> findByDateDebutBetween(LocalDateTime dateDebutParsed, LocalDateTime dateFinParsed);
}

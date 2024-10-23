package fr.reservacances.repository.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.utilisateur.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{


    Optional<Utilisateur> findByUsername(@NotEmpty String username);
}

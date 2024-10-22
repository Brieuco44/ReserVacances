package fr.reservacances.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservacances.model.utilisateur.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{

    
    
}

package fr.reservacances.repository.utilisateur;

import fr.reservacances.model.utilisateur.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}

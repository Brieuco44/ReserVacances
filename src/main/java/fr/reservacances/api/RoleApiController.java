package fr.reservacances.api;

import fr.reservacances.model.utilisateur.Role;
import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.RoleRepository;
import fr.reservacances.repository.VoitureRepository;
import fr.reservacances.request.CreateOrUpdateVoiture;
import fr.reservacances.request.RoleRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
@Log4j2
public class RoleApiController {
    private final RoleRepository roleRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody RoleRequest request) {
        Role role = new Role();

        role.setNom(request.getNom());

        this.roleRepository.save(role);

        log.debug("Voiture {} créée!", role.getId());

        return role.getId();
    }
}

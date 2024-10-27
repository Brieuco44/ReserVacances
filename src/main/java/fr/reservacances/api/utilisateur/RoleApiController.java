package fr.reservacances.api.utilisateur;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import fr.reservacances.model.utilisateur.Role;
import fr.reservacances.repository.utilisateur.RoleRepository;
import fr.reservacances.request.utilisateur.RoleRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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

        log.debug("Role {} créé!", role.getId());

        return role.getId();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @Valid @RequestBody RoleRequest request) {
        Role role = this.roleRepository.findById(id).orElseThrow();

        role.setNom(request.getNom());

        this.roleRepository.save(role);

        log.debug("Role {} mis à jour!", role.getId());
    }
}

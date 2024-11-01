package fr.reservacances.api.localisation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.localisation.PaysNotFoundException;
import fr.reservacances.exception.localisation.VilleNotFoundException;
import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.repository.localisation.PaysRepository;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.request.localisation.CreateOrUpdateVilleRequest;
import fr.reservacances.response.localisation.VilleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/ville")
@RequiredArgsConstructor
@Log4j2
public class VilleApiController {
    private final VilleRepository repository;
    private final PaysRepository paysRepository;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVille(@Valid @RequestBody CreateOrUpdateVilleRequest request) {
        Ville ville = new Ville();

        Pays pays = this.paysRepository.findById(request.getPaysId())
                .orElseThrow(PaysNotFoundException::new);

        ville.setNom(request.getNom());
        ville.setPays(pays);

        this.repository.save(ville);

        log.debug("Ville {} créée!", ville.getId());

        return ville.getId();
    }

    @GetMapping()
    public List<VilleResponse> findAll() {
        return this.repository.findAll().stream().map(this::convert).toList();
    }

    @GetMapping("/{id}")
    public VilleResponse findById(@PathVariable String id) {
        Ville ville = this.repository.findById(id).orElseThrow(VilleNotFoundException::new);
        VilleResponse resp = VilleResponse.builder().build();
        BeanUtils.copyProperties(ville, resp);
        return resp;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateVilleRequest request) {
        Ville ville = this.repository.findById(id).orElseThrow(VilleNotFoundException::new);
        BeanUtils.copyProperties(request, ville);
        log.debug("Ville {} mise à jour!", id);
        return ville.getId();
    }

    private VilleResponse convert(Ville ville) {
        VilleResponse resp = VilleResponse.builder().build();

        BeanUtils.copyProperties(ville, resp);

        return resp;
    }
}

package fr.reservacances.api.localisation;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.localisation.Ville;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.request.localisation.CreateOrUpdateVilleRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/ville")
@RequiredArgsConstructor
@Log4j2
public class VilleApiController {
    private final VilleRepository villeRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createVille(@Valid @RequestBody CreateOrUpdateVilleRequest request) {
        Ville ville = new Ville();

        BeanUtils.copyProperties(request, ville);

        this.villeRepository.save(ville);

        log.debug("Ville {} créée!", ville.getId());

        return ville.getId();
    }
}

package fr.reservacances.api;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.repository.PaysRepository;
import fr.reservacances.repository.VilleRepository;
import fr.reservacances.request.LocalisationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.VoitureRepository;
import fr.reservacances.request.CreateOrUpdateVoiture;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/localisation")
@RequiredArgsConstructor
@Log4j2
public class LocalisationApiController {
    private final PaysRepository paysRepository;
    private final VilleRepository villeRepository;

    @PostMapping("/pays")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPays(@Valid @RequestBody LocalisationRequest request) {
        Pays pays = new Pays();

        BeanUtils.copyProperties(request, pays);

        this.paysRepository.save(pays);

        log.debug("Pays {} créée!", pays.getId());

        return pays.getId();
    }

    @PostMapping("/ville")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVille(@Valid @RequestBody LocalisationRequest request) {
        Ville ville = new Ville();

        BeanUtils.copyProperties(request, ville);

        this.villeRepository.save(ville);

        log.debug("Ville {} créée!", ville.getId());

        return ville.getId();
    }
}

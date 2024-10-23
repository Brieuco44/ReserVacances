package fr.reservacances.api.voiture;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.voiture.VoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateVoitureRequest;
import fr.reservacances.response.VoitureResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/voiture")
@RequiredArgsConstructor
@Log4j2
public class VoitureApiController {
    private final VoitureRepository voitureRepository;

 @GetMapping
    public List<VoitureResponse> findAll() {
        log.debug("Finding all videos ...");

        return this.voitureRepository.findAll()
            .stream()
            .map(this::convert)
            .toList()
        ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @PreAuthorize("isAuthenticated()") // CREER UN ROLE CAR_MANAGER ET UTILISER LA METHODE iSCarManager() DU SECURITY SERVICE
    public String create(@Valid @RequestBody CreateOrUpdateVoitureRequest request, Authentication authentication) {
        Voiture voiture = new Voiture();
        BeanUtils.copyProperties(request, voiture);
        
        this.voitureRepository.save(voiture);
        
        log.debug("Voiture {} créée!", voiture.getId());
        
        return voiture.getId();
    }

    private VoitureResponse convert(Voiture voiture) {
        VoitureResponse resp = VoitureResponse.builder().build();

        BeanUtils.copyProperties(voiture, resp);

        return resp;
    }
}
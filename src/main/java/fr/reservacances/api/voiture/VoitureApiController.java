package fr.reservacances.api.voiture;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.voiture.VoitureNotFoundException;
import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.voiture.VoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateVoitureRequest;
import fr.reservacances.response.voiture.VoitureResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/voiture")
@RequiredArgsConstructor
@Log4j2
public class VoitureApiController {
    private final VoitureRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @PreAuthorize("isAuthenticated()") // CREER UN ROLE CAR_MANAGER ET UTILISER
    // LA METHODE iSCarManager() DU SECURITY SERVICE
    public String create(@Valid @RequestBody CreateOrUpdateVoitureRequest request) {
        Voiture voiture = new Voiture();
        BeanUtils.copyProperties(request, voiture);

        this.repository.save(voiture);

        log.debug("Voiture {} créée!", voiture.getId());

        return voiture.getId();
    }

    @GetMapping
    public List<VoitureResponse> findAll() {
        log.debug("Finding all voitures ...");

        return this.repository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/id")
    public VoitureResponse findById(@PathVariable String id) {
        Voiture voiture = this.repository.findById(id).orElseThrow(VoitureNotFoundException::new);
        return VoitureResponse.builder()
            .id(voiture.getId())
            .prix(voiture.getPrix())
            .modeleVoitureId(voiture.getModeleVoiture().getId())
            .villeId(voiture.getVille().getId())
            .build();
    }


    private VoitureResponse convert(Voiture voiture) {
        VoitureResponse resp = VoitureResponse.builder().build();

        BeanUtils.copyProperties(voiture, resp);

        return resp;
    }



}
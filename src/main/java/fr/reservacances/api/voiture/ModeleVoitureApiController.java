package fr.reservacances.api.voiture;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.voiture.Marque;
import fr.reservacances.model.voiture.ModeleVoiture;
import fr.reservacances.repository.voiture.MarqueRepository;
import fr.reservacances.repository.voiture.ModeleVoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateModeleVoiture;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/modele/voiture")
@RequiredArgsConstructor
@Log4j2
public class ModeleVoitureApiController {
    private final ModeleVoitureRepository repository;
    private final MarqueRepository marqueRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @PreAuthorize("isAuthenticated()") // CREER UN ROLE CAR_MANAGER ET UTILISER
    // LA METHODE iSCarManager() DU SECURITY SERVICE
    public String create(@Valid @RequestBody CreateOrUpdateModeleVoiture request) {
        Optional<Marque> optMarque = this.marqueRepository.findById(request.getMarqueId());

        if (optMarque.isPresent()) {
            Marque marque = optMarque.get();

            ModeleVoiture modeleVoiture = new ModeleVoiture();
            modeleVoiture.setMarque(marque);
            modeleVoiture.setNom(request.getNom());
            modeleVoiture.setNbPlace(request.getNbPlace());

            if (request.getDescription() != null && !request.getDescription().isEmpty()) {
                modeleVoiture.setDescription(request.getDescription());
            }

            this.repository.save(modeleVoiture);

            log.debug("Marque {} créée!", modeleVoiture.getId());

            return modeleVoiture.getId();
        }

        return "Id " + request.getMarqueId() + "non trouvé, échec de la sauvegarde !";

    }
}

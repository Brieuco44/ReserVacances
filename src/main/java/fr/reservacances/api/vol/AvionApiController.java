package fr.reservacances.api.vol;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.model.vol.Avion;
import fr.reservacances.model.vol.Compagnie;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.repository.vol.AvionRepository;
import fr.reservacances.repository.vol.CompagnieRepository;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.request.vol.CreateOrUpdateAeroportRequest;
import fr.reservacances.request.vol.CreateOrUpdateAvionRequest;
import fr.reservacances.response.vol.AeroportInfoResponse;
import fr.reservacances.response.vol.AvionInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/avion")
@RequiredArgsConstructor
@Log4j2
public class AvionApiController {
    private final AvionRepository avionrepository;
    private final ModelAvionRepository modeleavionrepo;
    private final CompagnieRepository compagnierepo;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AvionInfoResponse createAeroport(@Valid @RequestBody CreateOrUpdateAvionRequest request) {
        Avion avion = new Avion();

        updateAvion(request, avion);

        log.debug("Avion {} créée!", avion.getId());

        return this.convertInfo(avion);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AvionInfoResponse updateAeroport(@PathVariable String id, @Valid @RequestBody CreateOrUpdateAvionRequest request) {
        Avion avion = this.avionrepository.findById(id).orElseThrow();

        updateAvion(request, avion);

        log.debug("Avion {} mise à jour!", avion.getId());

        return this.convertInfo(avion);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAeroport(@PathVariable String id) {
        Avion avion = this.avionrepository.findById(id).orElseThrow();
        this.avionrepository.delete(avion);
    }



    private void updateAvion(CreateOrUpdateAvionRequest request, Avion avion) {
        Compagnie compagnie = this.compagnierepo.findById(request.getCompagnieId()).orElseThrow();
        ModeleAvion modeleAvion = this.modeleavionrepo.findById(request.getModeleAvionId()).orElseThrow();

        avion.setCompagnie(compagnie);
        avion.setModeleAvion(modeleAvion);

        BeanUtils.copyProperties(request, avion);

        this.avionrepository.save(avion);
    }

    private AvionInfoResponse convertInfo(Avion aeroport) {
        Compagnie compagnie = aeroport.getCompagnie();
        ModeleAvion modeleAvion = aeroport.getModeleAvion();

        return AvionInfoResponse.builder()
                .id(aeroport.getId())
                .idcompagnie(compagnie.getId())
                .nomcompagnie(compagnie.getNom())
                .idmodeleavion(modeleAvion.getId())
                .nommodeleavion(modeleAvion.getNom())
                .build();
    }
}

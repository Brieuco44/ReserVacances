package fr.reservacances.api.vol;

import fr.reservacances.model.vol.Avion;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.request.vol.CreateOrUpdateAvionModelRequest;
import fr.reservacances.request.vol.CreateOrUpdateAvionRequest;
import fr.reservacances.response.vol.ModelAvionInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/modelavion")
@RequiredArgsConstructor
@Log4j2
public class ModelAvionApiController {
    private final ModelAvionRepository modeleavionrepo;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAvionInfoResponse createAeroport(@Valid @RequestBody CreateOrUpdateAvionModelRequest request) {
        ModeleAvion modeleAvion = new ModeleAvion();

        BeanUtils.copyProperties(request, modeleAvion);

        modeleavionrepo.save(modeleAvion);

        log.debug("ModeleAvion {} créée!", modeleAvion.getId());

        return this.convertInfo(modeleAvion);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAvionInfoResponse updateAeroport(@PathVariable String id, @Valid @RequestBody CreateOrUpdateAvionModelRequest request) {
        ModeleAvion modeleAvion = this.modeleavionrepo.findById(id).orElseThrow();

        BeanUtils.copyProperties(request, modeleAvion);

        modeleavionrepo.save(modeleAvion);

        log.debug("ModeleAvion {} mise à jour!", modeleAvion.getId());

        return this.convertInfo(modeleAvion);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAeroport(@PathVariable String id) {
        ModeleAvion modeleAvion = this.modeleavionrepo.findById(id).orElseThrow();
        this.modeleavionrepo.delete(modeleAvion);
    }


    private ModelAvionInfoResponse convertInfo(ModeleAvion modeleAvion) {

        return ModelAvionInfoResponse.builder()
                .id(modeleAvion.getId())
                .nom(modeleAvion.getNom())
                .nbPassagers(modeleAvion.getNbPlace())
                .build();
    }
}

package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN')") // A voir si on le laisse ou pas
    public Iterable<ModelAvionInfoResponse> getModelAvions() {
        try {
            return this.modeleavionrepo.findAll().stream()
                    .map(this::convertInfo)
                    .toList();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN')") // A voir si on le laisse ou pas
    public ModelAvionInfoResponse getModelAvion(@PathVariable String id) {
        try {
            ModeleAvion modeleAvion = this.modeleavionrepo.findById(id).orElseThrow();
            return this.convertInfo(modeleAvion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAvionInfoResponse createModelAvion(@Valid @RequestBody CreateOrUpdateAvionModelRequest request) {
        try {
            ModeleAvion modeleAvion = new ModeleAvion();

            BeanUtils.copyProperties(request, modeleAvion);

            modeleavionrepo.save(modeleAvion);

            log.debug("ModeleAvion {} créée!", modeleAvion.getId());

            return this.convertInfo(modeleAvion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAvionInfoResponse updateModelAvion(@PathVariable String id, @Valid @RequestBody CreateOrUpdateAvionModelRequest request) {
        try {
            ModeleAvion modeleAvion = this.modeleavionrepo.findById(id).orElseThrow();

            BeanUtils.copyProperties(request, modeleAvion);

            modeleavionrepo.save(modeleAvion);

            log.debug("ModeleAvion {} mise à jour!", modeleAvion.getId());

            return this.convertInfo(modeleAvion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteModelAvion(@PathVariable String id) {
        try {
            ModeleAvion modeleAvion = this.modeleavionrepo.findById(id).orElseThrow();
            this.modeleavionrepo.delete(modeleAvion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    private ModelAvionInfoResponse convertInfo(ModeleAvion modeleAvion) {

        return ModelAvionInfoResponse.builder()
                .id(modeleAvion.getId())
                .nom(modeleAvion.getNom())
                .nbPassagers(modeleAvion.getNbPlace())
                .build();
    }
}

package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
import fr.reservacances.model.vol.Avion;
import fr.reservacances.model.vol.Compagnie;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.repository.vol.AvionRepository;
import fr.reservacances.repository.vol.CompagnieRepository;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.request.vol.CreateOrUpdateAvionRequest;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<AvionInfoResponse> getAvions() {
        try {
            return this.avionrepository.findAll().stream()
                    .map(this::convertInfo)
                    .toList();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvionInfoResponse getAvion(@PathVariable String id) {
        try {
            Avion avion = this.avionrepository.findById(id).orElseThrow();
            return this.convertInfo(avion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public AvionInfoResponse createAvion(@Valid @RequestBody CreateOrUpdateAvionRequest request) {
        try {
            Avion avion = new Avion();

            updateAvion(request, avion);

            log.debug("Avion {} créée!", avion.getId());

            return this.convertInfo(avion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public AvionInfoResponse updateAvion(@PathVariable String id, @Valid @RequestBody CreateOrUpdateAvionRequest request) {
        try {
            Avion avion = this.avionrepository.findById(id).orElseThrow();

            updateAvion(request, avion);

            log.debug("Avion {} mise à jour!", avion.getId());

            return this.convertInfo(avion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public void deleteAvion(@PathVariable String id) {
        try {
            Avion avion = this.avionrepository.findById(id).orElseThrow();
            this.avionrepository.delete(avion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    private void updateAvion(CreateOrUpdateAvionRequest request, Avion avion) {
        try {
            Compagnie compagnie = this.compagnierepo.findById(request.getCompagnieId()).orElseThrow();
            ModeleAvion modeleAvion = this.modeleavionrepo.findById(request.getModeleAvionId()).orElseThrow();

            avion.setCompagnie(compagnie);
            avion.setModeleAvion(modeleAvion);

            BeanUtils.copyProperties(request, avion);

            this.avionrepository.save(avion);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    private AvionInfoResponse convertInfo(Avion avion) {
        Compagnie compagnie = avion.getCompagnie();
        ModeleAvion modeleAvion = avion.getModeleAvion();

        return AvionInfoResponse.builder()
                .id(avion.getId())
                .idcompagnie(compagnie.getId())
                .nomcompagnie(compagnie.getNom())
                .idmodeleavion(modeleAvion.getId())
                .nommodeleavion(modeleAvion.getNom())
                .build();
    }
}

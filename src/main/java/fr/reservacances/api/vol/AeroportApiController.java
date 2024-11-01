package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.request.vol.CreateOrUpdateAeroportRequest;
import fr.reservacances.response.vol.AeroportInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/aeroport")
@RequiredArgsConstructor
@Log4j2
public class AeroportApiController {
    private final AeroportRepository aeroport;
    private final VilleRepository villerepo;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN')") // A voir si on le laisse ou pas
    public Iterable<AeroportInfoResponse> getAeroports() {
        try {
            return this.aeroport.findAll().stream()
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
    public AeroportInfoResponse getAeroport(@PathVariable String id) {
        try {
            Aeroport aeroport = this.aeroport.findById(id).orElseThrow();
            return this.convertInfo(aeroport);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AeroportInfoResponse createAeroport(@Valid @RequestBody CreateOrUpdateAeroportRequest request) {
        try{
            Aeroport aeroport = new Aeroport();

            Ville ville = this.villerepo.findById(request.getVille_id()).orElseThrow();

            aeroport.setVille(ville);

            BeanUtils.copyProperties(request, aeroport);

            this.aeroport.save(aeroport);

            log.debug("Aeroport {} créée!", aeroport.getId());

            return this.convertInfo(aeroport);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AeroportInfoResponse updateAeroport(@PathVariable String id, @Valid @RequestBody CreateOrUpdateAeroportRequest request) {
        try{
            Aeroport aeroport = this.aeroport.findById(id).orElseThrow();
            BeanUtils.copyProperties(request, aeroport);

            this.aeroport.save(aeroport);

            log.debug("Aeroport {} mise à jour!", aeroport.getId());

            return this.convertInfo(aeroport);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    private AeroportInfoResponse convertInfo(Aeroport aeroport) {
        Ville ville = aeroport.getVille();
        Pays pays = ville.getPays();

        return AeroportInfoResponse.builder()
                .id(aeroport.getId())
                .nom(aeroport.getNom())
                .villeId(ville.getId())
                .ville(ville.getNom())
                .paysId(pays.getId())
                .pays(pays.getNom())
                .build();
    }
}

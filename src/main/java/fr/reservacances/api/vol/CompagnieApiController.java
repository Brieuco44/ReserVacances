package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
import fr.reservacances.model.vol.Compagnie;
import fr.reservacances.repository.vol.CompagnieRepository;
import fr.reservacances.request.vol.CreateOrUpdateCompagnieRequest;
import fr.reservacances.response.vol.CompagnieInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/compagnie")
@RequiredArgsConstructor
@Log4j2
public class CompagnieApiController {
    private final CompagnieRepository compagnierepo;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CompagnieInfoResponse> getCompagnies() {
        try {
            return this.compagnierepo.findAll().stream()
                    .map(this::convertInfo)
                    .toList();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompagnieInfoResponse getCompagnie(@PathVariable String id) {
        try {
            Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();
            return this.convertInfo(compagnie);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public CompagnieInfoResponse createCompagnie(@Valid @RequestBody CreateOrUpdateCompagnieRequest request) {
        try {
            Compagnie compagnie = new Compagnie();

            BeanUtils.copyProperties(request, compagnie);

            compagnierepo.save(compagnie);

            log.debug("Compagnie {} créée!", compagnie.getId());

            return this.convertInfo(compagnie);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public CompagnieInfoResponse updateCompagnie(@PathVariable String id, @Valid @RequestBody CreateOrUpdateCompagnieRequest request) {
        try {
            Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();

            BeanUtils.copyProperties(request, compagnie);

            compagnierepo.save(compagnie);

            log.debug("Compagnie {} mise à jour!", compagnie.getId());

            return this.convertInfo(compagnie);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public void deleteCompagnie(@PathVariable String id) {
        try {
            Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();
            this.compagnierepo.delete(compagnie);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    private CompagnieInfoResponse convertInfo(Compagnie compagnie) {

        return CompagnieInfoResponse.builder()
                .id(compagnie.getId())
                .nom(compagnie.getNom())
                .build();
    }
}

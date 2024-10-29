package fr.reservacances.api.vol;

import fr.reservacances.model.vol.Compagnie;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.repository.vol.CompagnieRepository;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.request.vol.CreateOrUpdateCompagnieRequest;
import fr.reservacances.response.vol.CompagnieInfoResponse;
import fr.reservacances.response.vol.ModelAvionInfoResponse;
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
    //@PreAuthorize("hasRole('ROLE_ADMIN')") // A voir si on le laisse ou pas
    public Iterable<CompagnieInfoResponse> getCompagnies() {
        return this.compagnierepo.findAll().stream()
                .map(this::convertInfo)
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasRole('ROLE_ADMIN')") // A voir si on le laisse ou pas
    public CompagnieInfoResponse getCompagnie(@PathVariable String id) {
        Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();
        return this.convertInfo(compagnie);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CompagnieInfoResponse createCompagnie(@Valid @RequestBody CreateOrUpdateCompagnieRequest request) {
        Compagnie compagnie = new Compagnie();

        BeanUtils.copyProperties(request, compagnie);

        compagnierepo.save(compagnie);

        log.debug("Compagnie {} créée!", compagnie.getId());

        return this.convertInfo(compagnie);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CompagnieInfoResponse updateCompagnie(@PathVariable String id, @Valid @RequestBody CreateOrUpdateCompagnieRequest request) {
        Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();

        BeanUtils.copyProperties(request, compagnie);

        compagnierepo.save(compagnie);

        log.debug("Compagnie {} mise à jour!", compagnie.getId());

        return this.convertInfo(compagnie);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCompagnie(@PathVariable String id) {
        Compagnie compagnie = this.compagnierepo.findById(id).orElseThrow();
        this.compagnierepo.delete(compagnie);
    }


    private CompagnieInfoResponse convertInfo(Compagnie compagnie) {

        return CompagnieInfoResponse.builder()
                .id(compagnie.getId())
                .nom(compagnie.getNom())
                .build();
    }
}

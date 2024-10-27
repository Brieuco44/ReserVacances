package fr.reservacances.api.localisation;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.repository.localisation.PaysRepository;
import fr.reservacances.request.localisation.CreateOrUpdatePaysRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/pays")
@RequiredArgsConstructor
@Log4j2
public class PaysApiController {
    private final PaysRepository paysRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public String createPays(@Valid @RequestBody CreateOrUpdatePaysRequest request) {
        Pays pays = new Pays();

        BeanUtils.copyProperties(request, pays);

        this.paysRepository.save(pays);

        log.debug("Pays {} créée!", pays.getId());

        return pays.getId();
    }
}

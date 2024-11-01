package fr.reservacances.api.localisation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.localisation.PaysNotFoundException;
import fr.reservacances.model.localisation.Pays;
import fr.reservacances.repository.localisation.PaysRepository;
import fr.reservacances.request.localisation.CreateOrUpdatePaysRequest;
import fr.reservacances.response.localisation.PaysResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/pays")
@RequiredArgsConstructor
@Log4j2
public class PaysApiController {
    private final PaysRepository repository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createPays(@Valid @RequestBody CreateOrUpdatePaysRequest request) {
        Pays pays = new Pays();

        BeanUtils.copyProperties(request, pays);

        this.repository.save(pays);

        log.debug("Pays {} créée!", pays.getId());

        return pays.getId();
    }

    @GetMapping()
    public List<PaysResponse> findAll() {
        return this.repository.findAll().stream().map(this::convert).toList();
    }

    @GetMapping("/{id}")
    public PaysResponse findById(@PathVariable String id) {
        Pays pays = this.repository.findById(id).orElseThrow(PaysNotFoundException::new);
        PaysResponse resp = PaysResponse.builder().build();
        BeanUtils.copyProperties(pays, resp);
        return resp;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdatePaysRequest request) {
        Pays pays = this.repository.findById(id).orElseThrow(PaysNotFoundException::new);
        BeanUtils.copyProperties(request, pays);
        log.debug("Pays {} mis à jour!", id);
        return pays.getId();
    }

    private PaysResponse convert(Pays pays) {
        PaysResponse resp = PaysResponse.builder().build();

        BeanUtils.copyProperties(pays, resp);

        return resp;
    }
    
}

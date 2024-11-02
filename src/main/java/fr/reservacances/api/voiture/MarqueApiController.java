package fr.reservacances.api.voiture;

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

import fr.reservacances.exception.voiture.MarqueNotFoundException;
import fr.reservacances.model.voiture.Marque;
import fr.reservacances.repository.voiture.MarqueRepository;
import fr.reservacances.request.voiture.CreateOrUpdateMarqueRequest;
import fr.reservacances.response.voiture.MarqueResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/marque")
@RequiredArgsConstructor
@Log4j2
public class MarqueApiController {
    private final MarqueRepository repository;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody CreateOrUpdateMarqueRequest request) {
        Marque marque = new Marque();
        BeanUtils.copyProperties(request, marque);

        this.repository.save(marque);

        log.debug("Marque {} créée!", marque.getId());

        return marque.getId();
    }

    @GetMapping
    public List<MarqueResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public MarqueResponse findById(@PathVariable String id) {
        Marque marque = this.repository.findById(id).orElseThrow(MarqueNotFoundException::new);
        return MarqueResponse.builder()
                .id(id)
                .nom(marque.getNom())
                .build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateMarqueRequest request) {
        Marque marque = this.repository.findById(id).orElseThrow(MarqueNotFoundException::new);
        BeanUtils.copyProperties(request, marque);
        log.debug("Marque {} mise à jour!", id);
        return marque.getId();
    }

    private MarqueResponse convert(Marque marque) {
        MarqueResponse resp = MarqueResponse.builder().build();

        BeanUtils.copyProperties(marque, resp);

        return resp;
    }
}

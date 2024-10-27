package fr.reservacances.api.voiture;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.model.voiture.Marque;
import fr.reservacances.repository.voiture.MarqueRepository;
import fr.reservacances.request.voiture.CreateOrUpdateMarqueRequest;
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
    @ResponseStatus(HttpStatus.CREATED)
    // @PreAuthorize("isAuthenticated()") // CREER UN ROLE CAR_MANAGER ET UTILISER LA METHODE iSCarManager() DU SECURITY SERVICE
    public String create(@Valid @RequestBody CreateOrUpdateMarqueRequest request) {
        Marque marque = new Marque();
        BeanUtils.copyProperties(request, marque);
        
        this.repository.save(marque);
        
        log.debug("Marque {} créée!", marque.getId());
        
        return marque.getId();
    }
}

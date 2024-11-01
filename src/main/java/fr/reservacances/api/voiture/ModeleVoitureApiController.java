package fr.reservacances.api.voiture;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.voiture.MarqueNotFoundException;
import fr.reservacances.exception.voiture.ModeleVoitureNotFoundException;
import fr.reservacances.model.voiture.Marque;
import fr.reservacances.model.voiture.ModeleVoiture;
import fr.reservacances.repository.voiture.MarqueRepository;
import fr.reservacances.repository.voiture.ModeleVoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateModeleVoiture;
import fr.reservacances.response.voiture.ModeleVoitureResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/modele/voiture")
@RequiredArgsConstructor
@Log4j2
public class ModeleVoitureApiController {
    private final ModeleVoitureRepository repository;
    private final MarqueRepository marqueRepository;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody CreateOrUpdateModeleVoiture request) {
        Marque marque = this.marqueRepository.findById(request.getMarqueId()).orElseThrow(MarqueNotFoundException::new);

        ModeleVoiture modeleVoiture = new ModeleVoiture();
        modeleVoiture.setMarque(marque);
        modeleVoiture.setNom(request.getNom());
        modeleVoiture.setNbPlace(request.getNbPlace());

        if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            modeleVoiture.setDescription(request.getDescription());
        }

        this.repository.save(modeleVoiture);

        log.debug("Modèle {} créé!", modeleVoiture.getId());

        return modeleVoiture.getId();
    }

    @GetMapping
    public List<ModeleVoitureResponse> findAll() {

        return this.repository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public ModeleVoitureResponse findById(@PathVariable String id) {
        ModeleVoiture modeleVoiture = this.repository.findById(id).orElseThrow(ModeleVoitureNotFoundException::new);

        return ModeleVoitureResponse.builder()
                .id(id)
                .nom(modeleVoiture.getNom())
                .build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateModeleVoiture request) {
        ModeleVoiture modeleVoiture = this.repository.findById(id).orElseThrow(ModeleVoitureNotFoundException::new);
        BeanUtils.copyProperties(request, modeleVoiture);
        log.debug("Marque {} mise à jour!", id);
        return modeleVoiture.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    public void deleteById(@PathVariable String id) {
        this.repository.deleteById(id);
        log.debug("Modèle voiture {} supprimé!", id);
    }

    private ModeleVoitureResponse convert(ModeleVoiture modeleVoiture) {
        ModeleVoitureResponse resp = ModeleVoitureResponse.builder().build();

        BeanUtils.copyProperties(modeleVoiture, resp);

        return resp;
    }
}

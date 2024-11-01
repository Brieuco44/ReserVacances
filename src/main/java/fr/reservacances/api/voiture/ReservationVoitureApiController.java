package fr.reservacances.api.voiture;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.utilisateur.UtilisateurNotFoundException;
import fr.reservacances.exception.voiture.ModeleVoitureNotFoundException;
import fr.reservacances.exception.voiture.ReservationVoitureNotFoundException;
import fr.reservacances.exception.voiture.VoitureNotFoundException;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.model.voiture.ModeleVoiture;
import fr.reservacances.model.voiture.ReservationVoiture;
import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.repository.voiture.ReservationVoitureRepository;
import fr.reservacances.repository.voiture.VoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateModeleVoiture;
import fr.reservacances.request.voiture.CreateOrUpdateReservationVoitureRequest;
import fr.reservacances.response.voiture.ModeleVoitureResponse;
import fr.reservacances.response.voiture.ReservationVoitureResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/reservation/voiture")
@RequiredArgsConstructor
@Log4j2
public class ReservationVoitureApiController {
    private final ReservationVoitureRepository repository;
    private final VoitureRepository voitureRepository;
    private final UtilisateurRepository utilisateurRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @PreAuthorize("isAuthenticated()") // CREER UN ROLE CAR_MANAGER ET UTILISER
    // LA METHODE iSCarManager() DU SECURITY SERVICE
    public String create(@Valid @RequestBody CreateOrUpdateReservationVoitureRequest request , Authentication authentication) {
        ReservationVoiture reservationVoiture = new ReservationVoiture();
        Utilisateur utilisateur = this.utilisateurRepository.findById(authentication.getPrincipal().toString()).orElseThrow(UtilisateurNotFoundException::new);
        Voiture voiture = this.voitureRepository.findById(request.voitureId).orElseThrow(VoitureNotFoundException::new);

        BeanUtils.copyProperties(request, reservationVoiture);
        reservationVoiture.setUtilisateur(utilisateur);
        reservationVoiture.setVoiture(voiture);

        this.repository.save(reservationVoiture);

        log.debug("Réservation de la voiture {} créée!", reservationVoiture.getId());

        return reservationVoiture.getId();
    }

    @GetMapping
    public List<ReservationVoitureResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping
    public List<ReservationVoitureResponse> findAllByUtilisateur(Authentication authentication) {
        Utilisateur utilisateur = utilisateurRepository.findById(authentication.getPrincipal().toString()).orElseThrow(UtilisateurNotFoundException::new);
        return this.repository.findAllByUtilisateur(utilisateur)
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public ReservationVoitureResponse findById(@PathVariable String id) {
        ReservationVoiture reservationVoiture = this.repository.findById(id).orElseThrow(ModeleVoitureNotFoundException::new);

        return ReservationVoitureResponse.builder()
                .id(id)
                .dateDebut(reservationVoiture.getDateDebut())
                .dateFin(reservationVoiture.getDateFin())
                .voitureId(reservationVoiture.getVoiture().getId())
                .utilisateurId(reservationVoiture.getUtilisateur().getId())
                .build();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateReservationVoitureRequest request) {
        ReservationVoiture reservationVoiture = this.repository.findById(id).orElseThrow(ReservationVoitureNotFoundException::new);
        BeanUtils.copyProperties(request, reservationVoiture);
        log.debug("Marque {} mise à jour!", id);
        return reservationVoiture.getId();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        this.repository.deleteById(id);
        log.debug("Modèle voiture {} supprimé!", id);
    }

    private ReservationVoitureResponse convert(ReservationVoiture reservationVoiture) {
        ReservationVoitureResponse resp = ReservationVoitureResponse.builder().build();

        BeanUtils.copyProperties(reservationVoiture, resp);

        return resp;
    }
    
}




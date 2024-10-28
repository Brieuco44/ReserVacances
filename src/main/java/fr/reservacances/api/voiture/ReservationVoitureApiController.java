package fr.reservacances.api.voiture;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.utilisateur.UtilisateurNotFoundException;
import fr.reservacances.exception.voiture.VoitureNotFoundException;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.model.voiture.ReservationVoiture;
import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.repository.voiture.ReservationVoitureRepository;
import fr.reservacances.repository.voiture.VoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateReservationVoitureRequest;
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
        System.out.println(authentication);
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

    
}




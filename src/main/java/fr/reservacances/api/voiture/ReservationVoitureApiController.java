package fr.reservacances.api.voiture;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
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

import fr.reservacances.constant.constant;
import fr.reservacances.exception.utilisateur.UtilisateurNotFoundException;
import fr.reservacances.exception.voiture.ModeleVoitureNotFoundException;
import fr.reservacances.exception.voiture.ReservationVoitureNotFoundException;
import fr.reservacances.exception.voiture.VoitureNotFoundException;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.model.voiture.ReservationVoiture;
import fr.reservacances.model.voiture.Voiture;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.repository.voiture.ReservationVoitureRepository;
import fr.reservacances.repository.voiture.VoitureRepository;
import fr.reservacances.request.voiture.CreateOrUpdateReservationVoitureRequest;
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
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody CreateOrUpdateReservationVoitureRequest request,
            Authentication authentication) {
        ReservationVoiture reservationVoiture = new ReservationVoiture();
        Utilisateur utilisateur = this.utilisateurRepository.findById(authentication.getPrincipal().toString())
                .orElseThrow(UtilisateurNotFoundException::new);
        Voiture voiture = this.voitureRepository.findById(request.voitureId).orElseThrow(VoitureNotFoundException::new);

        BeanUtils.copyProperties(request, reservationVoiture);
        reservationVoiture.setUtilisateur(utilisateur);
        reservationVoiture.setVoiture(voiture);

        this.repository.save(reservationVoiture);

        log.debug("Réservation de la voiture {} créée!", reservationVoiture.getId());

        return reservationVoiture.getId();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_CAR_MANAGER')")
    public List<ReservationVoitureResponse> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }


    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<ReservationVoitureResponse> findAllByUtilisateur(Authentication authentication) {
        Utilisateur utilisateur = utilisateurRepository.findById(authentication.getPrincipal().toString())
                .orElseThrow(UtilisateurNotFoundException::new);
        return this.repository.findAllByUtilisateurId(utilisateur.getId())
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ReservationVoitureResponse findById(@PathVariable String id, Authentication authentication) {
        ReservationVoiture reservationVoiture = this.repository.findById(id)
                .orElseThrow(ModeleVoitureNotFoundException::new);
        Utilisateur utilisateur = this.utilisateurRepository.findById(authentication.getPrincipal().toString())
                .orElseThrow(UtilisateurNotFoundException::new);

        // Vérification de la correspondance entre l'utilisateur et la réservation
        if (!reservationVoiture.getUtilisateur().getId().equals(utilisateur.getId()) && !authentication.getAuthorities().stream().anyMatch(authority->authority.getAuthority().equals(constant.ROLE_CAR_MANAGER))) {
            throw new AccessDeniedException("Vous ne pouvez pas accéder à cette réservation.");
        }
        return ReservationVoitureResponse.builder()
                .id(id)
                .dateDebut(reservationVoiture.getDateDebut())
                .dateFin(reservationVoiture.getDateFin())
                .voitureId(reservationVoiture.getVoiture().getId())
                .utilisateurId(reservationVoiture.getUtilisateur().getId())
                .build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateReservationVoitureRequest request, Authentication authentication) {
        ReservationVoiture reservationVoiture = this.repository.findById(id)
                .orElseThrow(ReservationVoitureNotFoundException::new);
        Utilisateur utilisateur = utilisateurRepository.findById(authentication.getPrincipal().toString())
                .orElseThrow(UtilisateurNotFoundException::new);

        if (!reservationVoiture.getUtilisateur().getId().equals(utilisateur.getId()) && !authentication.getAuthorities().stream().anyMatch(authority->authority.getAuthority().equals(constant.ROLE_CAR_MANAGER))) {
            throw new AccessDeniedException("Vous ne pouvez pas modifier cette réservation.");
        }
        BeanUtils.copyProperties(request, reservationVoiture);
        log.debug("Marque {} mise à jour!", id);
        return reservationVoiture.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteById(@PathVariable String id, Authentication authentication) {
        ReservationVoiture reservationVoiture = this.repository.findById(id).orElseThrow(ReservationVoitureNotFoundException::new);
        Utilisateur utilisateur = utilisateurRepository.findById(authentication.getPrincipal().toString()).orElseThrow(UtilisateurNotFoundException::new);
    
        if (!reservationVoiture.getUtilisateur().getId().equals(utilisateur.getId()) && !authentication.getAuthorities().stream().anyMatch(authority->authority.getAuthority().equals(constant.ROLE_CAR_MANAGER))) {
            throw new AccessDeniedException("Vous ne pouvez pas supprimer cette réservation.");
        }
    
        this.repository.deleteById(id);
        log.debug("Réservation {} supprimée!", id);
    }

    private ReservationVoitureResponse convert(ReservationVoiture reservationVoiture) {
        ReservationVoitureResponse resp = ReservationVoitureResponse.builder().build();

        BeanUtils.copyProperties(reservationVoiture, resp);

        return resp;
    }

}

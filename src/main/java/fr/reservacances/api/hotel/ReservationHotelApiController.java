package fr.reservacances.api.hotel;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import fr.reservacances.exception.hotel.ChambreNotFoundException;
import fr.reservacances.exception.hotel.ReservatioHotelNotFoundException;
import fr.reservacances.exception.utilisateur.UtilisateurNotFoundException;
import fr.reservacances.model.hotel.Chambre;
import fr.reservacances.model.hotel.ReservationHotel;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.repository.hotel.ChambreRepository;
import fr.reservacances.repository.hotel.ReservationHotelRepository;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.request.hotel.CreateOrUpdateReservationHotelRequest;
import fr.reservacances.response.Hotel.ReservationHotelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/reservation-hotel")
@RequiredArgsConstructor
@Log4j2
public class ReservationHotelApiController {

    private final ReservationHotelRepository reservationHotelRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ChambreRepository chambreRepository;

    @GetMapping
    public List<ReservationHotelResponse> findAll() {
        log.debug("Recherche des reservations ...");

        return this.reservationHotelRepository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public ReservationHotelResponse findById(@PathVariable String id) {
        log.debug("Recherche de la reservation {} ...", id);

        ReservationHotel reservationHotel = this.reservationHotelRepository.findById(id)
                .orElseThrow(ReservatioHotelNotFoundException::new);
        ReservationHotelResponse resp = ReservationHotelResponse.builder().build();

        BeanUtils.copyProperties(reservationHotel, resp);

        return resp;
    }

    private ReservationHotelResponse convert(ReservationHotel reservationHotel) {
        ReservationHotelResponse resp = ReservationHotelResponse.builder().build();
        BeanUtils.copyProperties(reservationHotel, resp);
        return resp;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public String create(@Valid @RequestBody CreateOrUpdateReservationHotelRequest request,
            Authentication authentication) {
        ReservationHotel reservationHotel = new ReservationHotel();
        Utilisateur utilisateur = this.utilisateurRepository
                .findById((String) SecurityContextHolder.getContext().getAuthentication()
                        .getPrincipal())
                .orElseThrow(UtilisateurNotFoundException::new);
        Chambre chambre = this.chambreRepository.findById(request.getChambreId())
                .orElseThrow(ChambreNotFoundException::new);
        boolean reservationsDisponible = reservationHotelRepository.isChambreDisponible(
                request.getChambreId(),
                request.getDateDebut(),
                request.getDateFin());
        if (!reservationsDisponible) {
            return "La chambre est déjà réservée pour la période sélectionnée.";
        }

        BeanUtils.copyProperties(request, reservationHotel);
        reservationHotel.setUtilisateur(utilisateur);
        reservationHotel.setChambre(chambre);

        this.reservationHotelRepository.save(reservationHotel);

        log.debug("Réservation {} créée!", reservationHotel.getId());

        return reservationHotel.getId();
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateReservationHotelRequest request,
            Authentication authentication) {
        ReservationHotel reservationHotel = this.reservationHotelRepository.findById(id)
                .orElseThrow(ReservatioHotelNotFoundException::new);
        Chambre chambre = this.chambreRepository.findById(request.getChambreId())
                .orElseThrow(ChambreNotFoundException::new);
        Utilisateur utilisateur = this.utilisateurRepository.findById(authentication.getPrincipal().toString())
                .orElseThrow(UtilisateurNotFoundException::new);
        boolean reservationsDisponible = reservationHotelRepository.isChambreDisponible(
                request.getChambreId(),
                request.getDateDebut(),
                request.getDateFin());
        if (!reservationsDisponible) {
            return "La chambre est déjà réservée pour la période sélectionnée.";
        }

        BeanUtils.copyProperties(request, reservationHotel);
        reservationHotel.setUtilisateur(utilisateur);
        reservationHotel.setChambre(chambre);

        this.reservationHotelRepository.save(reservationHotel);

        log.debug("Réservation {} créée!", reservationHotel.getId());

        return reservationHotel.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void delete(@PathVariable String id) {
        ReservationHotel reservationHotel = this.reservationHotelRepository.findById(id)
                .orElseThrow(ReservatioHotelNotFoundException::new);

        this.reservationHotelRepository.delete(reservationHotel);

        log.debug("Réservation {} supprimée!", id);
    }

}

package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
import fr.reservacances.exception.vol.NotEnouthPlaceException;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.model.vol.ReservationVol;
import fr.reservacances.model.vol.Vol;
import fr.reservacances.repository.vol.ReservationVolRepository;
import fr.reservacances.repository.vol.VolRepository;
import fr.reservacances.request.vol.CreateOrUpdateReservationVolRequest;
import fr.reservacances.response.vol.ReservationVolInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/reservationvol")
@RequiredArgsConstructor
@Log4j2
public class ReservationVolApiController {
    private final ReservationVolRepository reservationVolRepository;
    private final VolRepository volRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public ReservationVolInfoResponse createReservation(@Valid @RequestBody CreateOrUpdateReservationVolRequest request) {
        try{
            // verify that stay places are available
            Integer nbPlacesAvailable = getNbPlacesAvailable(request.getVolId());

            if (nbPlacesAvailable < request.getNbAdulte() + request.getNbEnfant()) {
                throw new NotEnouthPlaceException();
            }

            ReservationVol reservationVol = new ReservationVol();

            BeanUtils.copyProperties(request, reservationVol);

            String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            System.out.println("utilisateurid: " + utilisateurid);

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(utilisateurid);

            Vol vol = new Vol();
            vol.setId(request.getVolId());

            reservationVol.setUtilisateur(utilisateur);
            reservationVol.setVol(vol);

            log.debug("ReservationVol {} créée!", reservationVol.getId());

            this.reservationVolRepository.save(reservationVol);

            return convertInfo(reservationVol);
        } catch (Exception e) {
            log.error(e);
            //throw new ErrorThrowException();
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/nbplaces/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public Integer getNbPlacesAvailable(@PathVariable String volId) {
        try{
            // Get model nb places available by vol id
            ModeleAvion modeleAvion = this.volRepository.findById(volId).orElseThrow().getAvion().getModeleAvion();

            Integer nbPlaces = modeleAvion.getNbPlace();

            // Get total nb places reserved by vol id
            Integer nbPlacesReserved = this.reservationVolRepository.getTotalPlacesByVolId(volId);

            return nbPlaces - nbPlacesReserved;
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public ReservationVolInfoResponse updateReservation(@PathVariable String id, @Valid @RequestBody CreateOrUpdateReservationVolRequest request) {
        try{
            // Update the reservation by id and verify that the user is the owner of the reservation
            String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            ReservationVol reservationVol = this.reservationVolRepository.findById(id).orElseThrow();

            if (!reservationVol.getUtilisateur().getId().equals(utilisateurid)) {
                throw new RuntimeException("You are not the owner of this reservation");
            }

            BeanUtils.copyProperties(request, reservationVol);

            this.reservationVolRepository.save(reservationVol);

            log.debug("ReservationVol {} mise à jour!", reservationVol.getId());

            return convertInfo(reservationVol);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("isAuthenticated()")
    public void deleteReservation(@PathVariable String id) {
        try{
            // Delete the reservation by id and verify that the user is the owner of the reservation
            String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            ReservationVol reservationVol = this.reservationVolRepository.findById(id).orElseThrow();

            if (!reservationVol.getUtilisateur().getId().equals(utilisateurid)) {
                throw new RuntimeException("You are not the owner of this reservation");
            }

            this.reservationVolRepository.deleteById(id);

            log.debug("ReservationVol {} supprimée!", id);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }


    private ReservationVolInfoResponse convertInfo(ReservationVol reservationVol) {
        Utilisateur utilisateur = reservationVol.getUtilisateur();
        Vol vol = reservationVol.getVol();


        return ReservationVolInfoResponse.builder()
                .id(reservationVol.getId())
                .nbAdulte(reservationVol.getNbAdulte())
                .nbEnfant(reservationVol.getNbEnfant())
                .utilisateurId(utilisateur.getId())
                .volId(vol.getId())
                .build();
    }
}

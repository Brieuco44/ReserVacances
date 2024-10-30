package fr.reservacances.api.vol;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.model.vol.ReservationVol;
import fr.reservacances.model.vol.Vol;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.repository.vol.ReservationVolRepository;
import fr.reservacances.repository.vol.VolRepository;
import fr.reservacances.request.vol.CreateOrUpdateAeroportRequest;
import fr.reservacances.request.vol.CreateOrUpdateReservationVolRequest;
import fr.reservacances.response.vol.AeroportInfoResponse;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ReservationVolInfoResponse createReservation(@Valid @RequestBody CreateOrUpdateReservationVolRequest request) {
        // verify that stay places are available
        Integer nbPlacesAvailable = getNbPlacesAvailable(request.getVolId());

        if (nbPlacesAvailable < request.getNbAdulte() + request.getNbEnfant()) {
            throw new RuntimeException("Not enough places available");
        }



        ReservationVol reservationVol = new ReservationVol();

        BeanUtils.copyProperties(request, reservationVol);

        String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurid);

        Vol vol = new Vol();
        vol.setId(request.getVolId());

        reservationVol.setUtilisateur(utilisateur);
        reservationVol.setVol(vol);

        log.debug("ReservationVol {} créée!", reservationVol.getId());

        this.reservationVolRepository.save(reservationVol);

        return convertInfo(reservationVol);
    }

    @GetMapping("/nbplaces/{volId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Integer getNbPlacesAvailable(@PathVariable String volId) {
        // Get model nb places available by vol id
        ModeleAvion modeleAvion = this.volRepository.findById(volId).orElseThrow().getAvion().getModeleAvion();

        Integer nbPlaces = modeleAvion.getNbPlace();

        // Get total nb places reserved by vol id
        Integer nbPlacesReserved = this.reservationVolRepository.getTotalPlacesByVolId(volId);

        return nbPlaces - nbPlacesReserved;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteReservation(@PathVariable String id) {
        // Delete the reservation by id and verify that the user is the owner of the reservation
        String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ReservationVol reservationVol = this.reservationVolRepository.findById(id).orElseThrow();

        if (!reservationVol.getUtilisateur().getId().equals(utilisateurid)) {
            throw new RuntimeException("You are not the owner of this reservation");
        }

        this.reservationVolRepository.deleteById(id);

        log.debug("ReservationVol {} supprimée!", id);
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

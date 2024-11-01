package fr.reservacances.api.vol;

import fr.reservacances.exception.ErrorThrowException;
import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.vol.*;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.repository.vol.AvionRepository;
import fr.reservacances.repository.vol.VolRepository;
import fr.reservacances.request.vol.CreateOrUpdateAvionModelRequest;
import fr.reservacances.request.vol.CreateOrUpdateVolRequest;
import fr.reservacances.response.vol.AeroportInfoResponse;
import fr.reservacances.response.vol.AvionInfoResponse;
import fr.reservacances.response.vol.ModelAvionInfoResponse;
import fr.reservacances.response.vol.VolInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vol")
@RequiredArgsConstructor
@Log4j2
public class VolApiController {
    private final VolRepository volRepository;
    private final AeroportRepository aeroportRepository;
    private final AvionRepository avionRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public Iterable<VolInfoResponse> getVol() {
        try {
            return this.volRepository.findAll().stream()
                    .map(this::convertInfo)
                    .toList();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public VolInfoResponse getVol(@PathVariable String id) {
        try {
            Vol vol = this.volRepository.findById(id).orElseThrow();
            return this.convertInfo(vol);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public Iterable<VolInfoResponse> searchVol(@RequestParam String dateDebut, @RequestParam String dateFin) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateDebutParsed = LocalDateTime.parse(dateDebut, formatter);
            LocalDateTime dateFinParsed = LocalDateTime.parse(dateFin, formatter);

            Optional<List<Vol>> listeVol = Optional.of(this.volRepository.findByDateDebutBetween(dateDebutParsed, dateFinParsed).orElseThrow());

            return listeVol.get().stream()
                    .map(this::convertInfo)
                    .toList();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    // get nb places restantes
    @GetMapping("/places/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("isAuthenticated()")
    public int getPlacesRestantes(@PathVariable String id) {
        try {
            Vol vol = this.volRepository.findById(id).orElseThrow();

            return vol.getAvion().getModeleAvion().getNbPlace();
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_VOL_MANAGER')")
    public VolInfoResponse createVol(@Valid @RequestBody CreateOrUpdateVolRequest request) {
        try {
            Vol vol = new Vol();
            BeanUtils.copyProperties(request, vol);

            // Affectation des dates converties
            vol.setDateDebut(request.getDateDebut());
            vol.setDateFin(request.getDateFin());

            Aeroport aeroportDepart = aeroportRepository.findById(request.getAeroportDepartId()).orElse(null);
            Aeroport aeroportArrivee = aeroportRepository.findById(request.getAeroportArriveeId()).orElse(null);

            vol.setAeroportDepart(aeroportDepart);
            vol.setAeroportArrivee(aeroportArrivee);

            Avion avion = avionRepository.findById(request.getAvionId()).orElse(null);
            vol.setAvion(avion);

            volRepository.save(vol);

            return convertInfo(vol);
        } catch (Exception e) {
            log.error(e);
            throw new ErrorThrowException();
        }
    }



    private VolInfoResponse convertInfo(Vol vol) {
        Aeroport aeroportDepart = vol.getAeroportDepart();
        Aeroport aeroportArrivee =vol.getAeroportArrivee();
        Avion avion =vol.getAvion();

        assert aeroportDepart != null;
        AeroportInfoResponse aeroportDepartInfo = AeroportInfoResponse.builder()
                .id(aeroportDepart.getId())
                .nom(aeroportDepart.getNom())
                .ville(String.valueOf(aeroportDepart.getVille()))
                .build();

        assert aeroportArrivee != null;
        AeroportInfoResponse aeroportArriveeInfo = AeroportInfoResponse.builder()
                .id(aeroportArrivee.getId())
                .nom(aeroportArrivee.getNom())
                .ville(String.valueOf(aeroportArrivee.getVille()))
                .build();

        assert avion != null;
        Compagnie compagnie = avion.getCompagnie();
        ModeleAvion modeleAvion = avion.getModeleAvion();

        AvionInfoResponse avioninfo = AvionInfoResponse.builder()
                .id(aeroportDepart.getId())
                .idcompagnie(compagnie.getId())
                .nomcompagnie(compagnie.getNom())
                .idmodeleavion(modeleAvion.getId())
                .nommodeleavion(modeleAvion.getNom())
                .build();

        return VolInfoResponse.builder()
                .id(vol.getId())
                .DateDepart(vol.getDateDebut().toString())
                .DateArrivee(vol.getDateFin().toString())
                .prixAdulte(vol.getPrixAdulte())
                .prixEnfant(vol.getPrixEnfant())
                .aeroportDepart(aeroportDepartInfo)
                .aeroportArrivee(aeroportArriveeInfo)
                .avion(avioninfo)
                .build();
    }
}

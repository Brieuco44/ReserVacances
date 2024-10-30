package fr.reservacances.api.vol;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.request.vol.CreateOrUpdateAeroportRequest;
import fr.reservacances.response.vol.AeroportInfoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol/reservationvol")
@RequiredArgsConstructor
@Log4j2
public class ReservationVolApiController {
    private final AeroportRepository aeroport;
    private final VilleRepository villerepo;

    private AeroportInfoResponse convertInfo(Aeroport aeroport) {
        Ville ville = aeroport.getVille();
        Pays pays = ville.getPays();

        return AeroportInfoResponse.builder()
                .id(aeroport.getId())
                .nom(aeroport.getNom())
                .villeId(ville.getId())
                .ville(ville.getNom())
                .paysId(pays.getId())
                .pays(pays.getNom())
                .build();
    }
}

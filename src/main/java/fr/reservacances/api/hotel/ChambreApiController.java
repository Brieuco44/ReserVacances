package fr.reservacances.api.hotel;

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

import fr.reservacances.exception.hotel.ChambreNotFoundException;
import fr.reservacances.exception.hotel.HotelNotFoundException;
import fr.reservacances.model.hotel.Chambre;
import fr.reservacances.model.hotel.Hotel;
import fr.reservacances.repository.hotel.ChambreRepository;
import fr.reservacances.repository.hotel.HotelRepository;
import fr.reservacances.request.hotel.CreateOrUpdateChambreRequest;
import fr.reservacances.response.Hotel.ChambreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/chambre")
@RequiredArgsConstructor
@Log4j2
public class ChambreApiController {
    private final ChambreRepository chambreRepository;
    private final HotelRepository hotelRepository;

    @GetMapping
    public List<ChambreResponse> findAll() {
        log.debug("Recherche des chambres ...");

        return this.chambreRepository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public ChambreResponse findById(@PathVariable String id) {
        log.debug("Recherche de la chambre {} ...", id);
        try {
            Chambre chambre = this.chambreRepository.findById(id).orElseThrow(ChambreNotFoundException::new);
            ChambreResponse resp = ChambreResponse.builder().build();

            BeanUtils.copyProperties(chambre, resp);
            return resp;
        } catch (Exception ex) {
            log.error("Chambre {} non trouvé !", id);
            throw new ChambreNotFoundException();
        }

    }

    @GetMapping("/hotel/{hotelId}")
    public List<ChambreResponse> findByHotel(@PathVariable String hotelId) {
        log.debug("Recherche des chambre de l'hotel {} ...", hotelId);
        return this.chambreRepository.findAllByHotelId(hotelId)
                .stream()
                .map(this::convert)
                .toList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_HOTEL_MANAGER')")
    public String createChambre(@Valid @RequestBody CreateOrUpdateChambreRequest request) {
        Chambre chambre = new Chambre();
        Hotel hotel = this.hotelRepository.findById(request.getHotelId()).orElseThrow(HotelNotFoundException::new);
        BeanUtils.copyProperties(request, chambre);
        chambre.setHotel(hotel);
        this.chambreRepository.save(chambre);

        log.debug("Chambre {} créée!", chambre.getId());

        return chambre.getId();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_HOTEL_MANAGER')")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateChambreRequest request) {
        log.debug("Modification Chambre {} ...", id);

        Chambre chambre = this.chambreRepository.findById(id).orElseThrow(ChambreNotFoundException::new);
        Hotel hotel = this.hotelRepository.findById(request.getHotelId()).orElseThrow(HotelNotFoundException::new);
        BeanUtils.copyProperties(request, chambre);
        chambre.setHotel(hotel);
        this.chambreRepository.save(chambre);

        log.debug("Chambre {} modifié !", id);

        return chambre.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_HOTEL_MANAGER')")
    public void deleteById(@PathVariable String id) {
        log.debug("Suppression de la chambre {} ...", id);

        try {
            this.chambreRepository.deleteById(id);
        } catch (Exception ex) {
            log.error("Imposible de supprimer la chambre {} !", id);
        }

        log.debug("Chambre {} supprimé!", id);
    }

    private ChambreResponse convert(Chambre chambre) {
        ChambreResponse resp = ChambreResponse.builder().build();
        BeanUtils.copyProperties(chambre, resp);
        return resp;
    }

}

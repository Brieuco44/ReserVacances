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

import fr.reservacances.exception.hotel.HotelNotFoundException;
import fr.reservacances.exception.localisation.VilleNotFoundException;
import fr.reservacances.model.hotel.Hotel;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.repository.hotel.HotelRepository;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.request.hotel.CreateOrUpdateHotelRequest;
import fr.reservacances.response.Hotel.HotelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
@Log4j2
public class HotelApiController {

    private final HotelRepository hotelRepository;
    private final VilleRepository villeRepository;

    @GetMapping
    public List<HotelResponse> findAll() {
        log.debug("Recherche des hotels ...");

        return this.hotelRepository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    @GetMapping("/{id}")
    public HotelResponse findById(@PathVariable String id) {
        log.debug("Recherche de l'hotel {} ...", id);

        Hotel hotel = this.hotelRepository.findById(id).orElseThrow(HotelNotFoundException::new);
        HotelResponse resp = HotelResponse.builder().build();

        BeanUtils.copyProperties(hotel, resp);

        return resp;
    }

    @GetMapping("/ville/{villeId}")
    public List<HotelResponse> findByVille(@PathVariable String villeId) {
        log.debug("Recherche des hotel dans la ville {} ...", villeId);
        return this.hotelRepository.findAllByVilleId(villeId)
                .stream()
                .map(this::convert)
                .toList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public String createHotel(@Valid @RequestBody CreateOrUpdateHotelRequest request) {
        Hotel hotel = new Hotel();
        Ville ville = this.villeRepository.findById(request.getVilleId()).orElseThrow(VilleNotFoundException::new);
        BeanUtils.copyProperties(request, hotel);
        hotel.setVille(ville);
        this.hotelRepository.save(hotel);

        log.debug("Hotel {} créée!", hotel.getId());

        return hotel.getId();
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public String update(@PathVariable String id, @Valid @RequestBody CreateOrUpdateHotelRequest request) {
        log.debug("Modification Hotel {} ...", id);

        Hotel hotel = this.hotelRepository.findById(id).orElseThrow(HotelNotFoundException::new);
        Ville ville = this.villeRepository.findById(request.getVilleId()).orElseThrow(VilleNotFoundException::new);
        BeanUtils.copyProperties(request, hotel);
        hotel.setVille(ville);
        this.hotelRepository.save(hotel);

        log.debug("Hotel {} modifié !", id);

        return hotel.getId();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public void deleteById(@PathVariable String id) {
        log.debug("Suppression de l'hotel {} ...", id);
        try {
            this.hotelRepository.deleteById(id);
        }
        catch (Exception ex) {
            log.error("Imposible de supprimer l'hotel {} !", id);
        }
        log.debug("Hotel {} supprimé!", id);
    }

    private HotelResponse convert(Hotel hotel) {
        HotelResponse resp = HotelResponse.builder().build();
        BeanUtils.copyProperties(hotel, resp);
        return resp;
    }

}

package fr.reservacances.api.hotel;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.localisation.VilleNotFoundException;
import fr.reservacances.model.hotel.Hotel;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.repository.hotel.HotelRepository;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.request.hotel.CreateOrUpdateHotelRequest;
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
}

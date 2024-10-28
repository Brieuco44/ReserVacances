package fr.reservacances.api.hotel;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.hotel.HotelNotFoundException;
import fr.reservacances.model.hotel.Chambre;
import fr.reservacances.model.hotel.Hotel;
import fr.reservacances.repository.hotel.ChambreRepository;
import fr.reservacances.repository.hotel.HotelRepository;
import fr.reservacances.request.hotel.CreateOrUpdateChambreRequest;
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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public String createChambre(@Valid @RequestBody CreateOrUpdateChambreRequest request) {
        Chambre chambre = new Chambre();
        Hotel hotel = this.hotelRepository.findById(request.getHotelId()).orElseThrow(HotelNotFoundException::new);
        BeanUtils.copyProperties(request, chambre);
        chambre.setHotel(hotel);
        this.chambreRepository.save(chambre);

        log.debug("Chambre {} créée!", chambre.getId());

        return chambre.getId();
    }

}

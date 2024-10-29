package fr.reservacances.api.hotel;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.reservacances.exception.hotel.HotelNotFoundException;
import fr.reservacances.exception.hotel.ReservatioHotelNotFoundException;
import fr.reservacances.model.hotel.Chambre;
import fr.reservacances.model.hotel.Hotel;
import fr.reservacances.model.hotel.ReservationHotel;
import fr.reservacances.repository.hotel.ReservationHotelRepository;
import fr.reservacances.request.hotel.CreateOrUpdateChambreRequest;
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

    @GetMapping("/hotel/{hotelId}")
    public List<ReservationHotelResponse> findByHotelId(@PathVariable String hotelId) {
        log.debug("Recherche des reservations de l'hotel {} ...", hotelId);

        return this.reservationHotelRepository.findByHotelId(hotelId)
                .stream()
                .map(this::convert)
                .toList();
    }


    private ReservationHotelResponse convert(ReservationHotel reservationHotel) {
        ReservationHotelResponse resp = ReservationHotelResponse.builder().build();
        BeanUtils.copyProperties(reservationHotel, resp);
        return resp;
    }

}

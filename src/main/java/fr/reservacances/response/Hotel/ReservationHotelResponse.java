package fr.reservacances.response.Hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationHotelResponse {

    private String id;
    private String dateDebut;
    private String dateFin;
    private String chambreId;
    private String clientId;
}

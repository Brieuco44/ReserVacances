package fr.reservacances.response.Hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChambreResponse {

    private String id;
    private String numero;
    private int nbPlace;
    private double prix;
    private String hotelId;
}

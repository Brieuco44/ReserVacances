package fr.reservacances.request.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrUpdateChambreRequest {

    @NotBlank
    private String numero;

    @NotNull
    private int nbPlace;

    @NotNull
    private double prix;

    @NotBlank
    private String hotelId;
}

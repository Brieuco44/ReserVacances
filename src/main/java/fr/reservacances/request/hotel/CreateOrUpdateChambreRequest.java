package fr.reservacances.request.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

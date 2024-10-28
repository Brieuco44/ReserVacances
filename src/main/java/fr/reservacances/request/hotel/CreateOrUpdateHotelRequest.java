package fr.reservacances.request.hotel;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrUpdateHotelRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String villeId;
}

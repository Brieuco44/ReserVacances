package fr.reservacances.request.hotel;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class CreateOrUpdateReservationHotelRequest {
    
    @NotBlank
    private String dateDebut;

    @NotBlank
    private String dateFin;

    @NotBlank
    private String chambreId;

    @NotBlank
    private String utilisateurId;
}

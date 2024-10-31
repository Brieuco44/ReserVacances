package fr.reservacances.request.hotel;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateReservationHotelRequest {

    @NotBlank
    private LocalDateTime dateDebut;

    @NotBlank
    private LocalDateTime dateFin;

    @NotBlank
    private String chambreId;

    @NotBlank
    private String utilisateurId;
}

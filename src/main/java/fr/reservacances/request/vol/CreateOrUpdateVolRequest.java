package fr.reservacances.request.vol;

import fr.reservacances.validator.ValidDateRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateVolRequest {

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    @NotNull
    private double prixAdulte;

    @NotNull
    private double prixEnfant;

    @NotBlank
    private String aeroportDepartId;

    @NotBlank
    private String aeroportArriveeId;

    @NotBlank
    private String avionId;
}

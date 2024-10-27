package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateVoitureRequest {
    
    @NotBlank
    private double prix;

    @NotBlank
    private String modeleVoitureId;

    @NotBlank
    private String villeId;

}

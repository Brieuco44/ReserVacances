package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@Builder
public class CreateOrUpdateVoitureRequest {
    
    @NotNull
    private double prix;

    @NotBlank
    private String modeleVoitureId;

    @NotBlank
    private String villeId;

}

package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder 
public class CreateOrUpdateVoitureRequest {
    
    @NotBlank
    private double prix;

    @NotBlank
    private String modeleVoitureId;

    @NotBlank
    private String villeId;

}

package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrUpdateMarqueRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String villeId;

}

package fr.reservacances.request.localisation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrUpdateVilleRequest {
    @NotBlank
    private String nom;

    @NotBlank
    private String paysId;
}

package fr.reservacances.request.localisation;

import jakarta.validation.constraints.NotBlank;

public class CreateOrUpdateVilleRequest {
    @NotBlank
    private String nom;

    @NotBlank
    private String paysId;
}

package fr.reservacances.request.localisation;

import jakarta.validation.constraints.NotBlank;

public class CreateOrUpdatePaysRequest {
    @NotBlank
    private String nom;
}

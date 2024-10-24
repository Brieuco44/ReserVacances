package fr.reservacances.request.localisation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrUpdatePaysRequest {
    @NotBlank
    private String nom;
}

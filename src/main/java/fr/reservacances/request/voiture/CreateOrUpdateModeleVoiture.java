package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrUpdateModeleVoiture {

    @NotBlank
    public String nom;

    @NotNull
    private int nbPlace;

    private String description;

    @NotBlank
    private String marqueId;
}
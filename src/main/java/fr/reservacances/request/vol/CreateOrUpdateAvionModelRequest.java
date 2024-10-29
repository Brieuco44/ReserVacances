package fr.reservacances.request.vol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAvionModelRequest {

    @NotBlank
    private String nom;

    @NotNull
    private int nbPlace;

}

package fr.reservacances.request.vol;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAvionModelRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private int nbPassagers;

}

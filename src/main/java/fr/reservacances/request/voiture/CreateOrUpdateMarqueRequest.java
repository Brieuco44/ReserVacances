package fr.reservacances.request.voiture;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateMarqueRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String villeId;

}

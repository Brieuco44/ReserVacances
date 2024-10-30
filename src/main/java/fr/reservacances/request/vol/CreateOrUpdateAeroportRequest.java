package fr.reservacances.request.vol;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAeroportRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String ville_id;
}

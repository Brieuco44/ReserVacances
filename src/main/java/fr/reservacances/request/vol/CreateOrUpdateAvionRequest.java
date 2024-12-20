package fr.reservacances.request.vol;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAvionRequest {

    @NotBlank
    private String compagnieId;


    @NotBlank
    private String modeleAvionId;

}

package fr.reservacances.request.vol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateReservationVolRequest {

    @NotNull
    private int nbAdulte;

    @NotNull
    private int nbEnfant;

    @NotBlank
    private String volId;

}

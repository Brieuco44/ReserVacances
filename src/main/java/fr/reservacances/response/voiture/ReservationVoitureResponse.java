package fr.reservacances.response.voiture;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class ReservationVoitureResponse {
    private String id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String voitureId;
    private String utilisateurId;
}

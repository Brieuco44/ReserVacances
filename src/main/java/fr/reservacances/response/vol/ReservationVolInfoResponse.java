package fr.reservacances.response.vol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class ReservationVolInfoResponse {
    private String id;
    private int nbAdulte;
    private int nbEnfant;
    private String utilisateurId;
    private String volId;
}

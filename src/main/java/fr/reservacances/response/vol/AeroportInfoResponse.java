package fr.reservacances.response.vol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AeroportInfoResponse {
    private String id;
    private String nom;
    private String villeId;
    private String ville;
    private String paysId;
    private String pays;

}

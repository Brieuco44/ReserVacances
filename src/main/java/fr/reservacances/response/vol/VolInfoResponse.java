package fr.reservacances.response.vol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class VolInfoResponse {
    private String id;
    private String DateDepart;
    private String DateArrivee;
    private Double prixAdulte;
    private Double prixEnfant;
    private AeroportInfoResponse aeroportDepart;
    private AeroportInfoResponse aeroportArrivee;
    private AvionInfoResponse avion;
}

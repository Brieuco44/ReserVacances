package fr.reservacances.response.voiture;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class VoitureResponse {

    private String id;
    private double prix;
    private String modeleVoitureId;
    private String villeId;
}

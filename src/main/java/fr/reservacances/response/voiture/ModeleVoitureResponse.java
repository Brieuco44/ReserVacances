package fr.reservacances.response.voiture;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class ModeleVoitureResponse {
    private String id;
    private String nom;
    private int nbPlace; 
    private String description;
    private String marqueId;
}

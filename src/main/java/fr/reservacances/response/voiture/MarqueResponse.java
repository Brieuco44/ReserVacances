package fr.reservacances.response.voiture;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Builder
public class MarqueResponse {
    private String id;
    private String nom;
}

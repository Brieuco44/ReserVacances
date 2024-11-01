package fr.reservacances.response.localisation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class VilleResponse {
    private String id;
    private String nom;
    private String paysId ;
}

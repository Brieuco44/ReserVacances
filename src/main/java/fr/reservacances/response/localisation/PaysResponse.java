package fr.reservacances.response.localisation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class PaysResponse {
    public String id;
    public String nom;
}

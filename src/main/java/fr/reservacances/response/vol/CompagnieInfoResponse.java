package fr.reservacances.response.vol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CompagnieInfoResponse {
    private String id;
    private String nom;
}

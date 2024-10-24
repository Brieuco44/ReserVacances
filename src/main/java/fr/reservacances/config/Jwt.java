package fr.reservacances.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Jwt {
    private String utilisateurId;
    private String username;
    private boolean valid;
}

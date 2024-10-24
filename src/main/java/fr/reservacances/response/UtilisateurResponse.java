package fr.reservacances.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UtilisateurResponse {
    private boolean success;
    private String token;

}

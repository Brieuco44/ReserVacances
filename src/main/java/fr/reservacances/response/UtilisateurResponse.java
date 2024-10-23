package fr.reservacances.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class UtilisateurResponse {
    private String id;
    private String username;

}

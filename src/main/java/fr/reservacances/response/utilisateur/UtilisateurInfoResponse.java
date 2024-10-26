package fr.reservacances.response.utilisateur;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UtilisateurInfoResponse {
    private String id;
    private String username;
    private String email;
    private String nom;
    private String prenom;
    private String telephone;

}

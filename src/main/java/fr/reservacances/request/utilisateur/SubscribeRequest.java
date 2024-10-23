package fr.reservacances.request.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubscribeRequest {

    @NotEmpty
    private String nom;

    @NotEmpty
    private String prenom;

    @NotEmpty
    private String email;

    @NotEmpty
    private String telephone;

    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @NotEmpty
    private String role_id;
}

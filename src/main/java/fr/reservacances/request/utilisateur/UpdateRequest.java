package fr.reservacances.request.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {

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
}

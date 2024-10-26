package fr.reservacances.request.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequest {
    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 2)
    private String password;
}

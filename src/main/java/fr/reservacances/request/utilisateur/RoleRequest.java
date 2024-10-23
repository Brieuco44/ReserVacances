package fr.reservacances.request.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoleRequest {
    @NotEmpty
    private String nom;
}

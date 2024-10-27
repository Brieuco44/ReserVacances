package fr.reservacances.request.utilisateur;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    @NotEmpty
    private String nom;
}

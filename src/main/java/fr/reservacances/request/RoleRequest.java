package fr.reservacances.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoleRequest {
    @NotEmpty
    private String nom;
}

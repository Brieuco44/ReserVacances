package fr.reservacances.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocalisationRequest {

    @NotBlank
    private String nom;

    @Null
    private String paysId;
}

package fr.reservacances.request.voiture;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateReservationVoitureRequest {
  
    @NotNull(message = "La date de début ne peut pas être nulle")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    public LocalDateTime dateDebut;

    @NotNull(message = "La date de fin ne peut pas être nulle")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime dateFin;

    @NotBlank
    public String voitureId;

      // public String id;

    // public String utilisateurId;
}

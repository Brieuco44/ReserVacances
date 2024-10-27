package fr.reservacances.request.voiture;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrUpdateReservationVoitureRequest {
    public String id;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public LocalDateTime dateDebut;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public LocalDateTime dateFin;

    public String voitureId;

    public String utilisateurId;
}

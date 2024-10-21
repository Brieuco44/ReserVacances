package fr.reservacances.model.voiture;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import fr.reservacances.model.utilisateur.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation_voiture")
@Getter @Setter
public class ReservationVoiture {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private LocalDateTime dateDebut;

    @Column(nullable = false)
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "voiture_id", nullable = false)
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;
}

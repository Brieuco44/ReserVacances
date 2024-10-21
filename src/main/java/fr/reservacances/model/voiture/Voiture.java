package fr.reservacances.model.voiture;

import org.hibernate.annotations.UuidGenerator;

import fr.reservacances.model.localisation.Ville;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voiture")
@Getter @Setter
public class Voiture {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name = "modele_id", nullable = false)
    private ModeleVoiture modeleVoiture;

    @ManyToOne
    @JoinColumn(name = "modele_id", nullable = false)
    private Ville ville;

}

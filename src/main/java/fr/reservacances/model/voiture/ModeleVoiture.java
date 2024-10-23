package fr.reservacances.model.voiture;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modele_voiture")
@Getter @Setter
public class ModeleVoiture {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "nb_place", nullable = false)
    private int nbPlace; 

    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;
}

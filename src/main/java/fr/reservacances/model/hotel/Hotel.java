package fr.reservacances.model.hotel;

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
@Table(name = "hotel")
@Getter
@Setter
public class Hotel {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "ville_id", nullable = false)
    private Ville ville;
}

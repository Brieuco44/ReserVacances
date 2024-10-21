package fr.reservacances.model.localisation;

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
@Table(name = "ville")
@Getter @Setter
public class Ville {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;
}

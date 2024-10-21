package fr.reservacances.model.vol;

import java.time.LocalDateTime;

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
@Table(name = "vol")
@Getter
@Setter
public class Vol {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private LocalDateTime dateDebut;

    @Column(nullable = false)
    private LocalDateTime dateFin;

    @Column(nullable = false)
    private double prixEnfant;

    @Column(nullable = false)
    private double prixAdulte;

    @ManyToOne
    @JoinColumn(name = "aeroport_depart_id", nullable = false)
    private Aeroport aeroportDepart;

    @ManyToOne
    @JoinColumn(name = "aeroport_arrivee_id", nullable = false)
    private Aeroport aeroportArrivee;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

}

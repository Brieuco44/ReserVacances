package fr.reservacances.model.vol;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "avion")
@Getter @Setter
public class Avion {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JoinColumn(name = "modele_avion_id", nullable = false)
    private ModeleAvion modeleAvion;

    @ManyToOne
    @JoinColumn(name = "compagnie_id", nullable = false)
    private Compagnie compagnie;

}

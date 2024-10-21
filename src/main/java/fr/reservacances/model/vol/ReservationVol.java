package fr.reservacances.model.vol;

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
@Table(name = "reservation_vol")
@Getter
@Setter
public class ReservationVol {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private int nbAdulte;

    @Column(nullable = false)
    private int nbEnfant;

    @ManyToOne
    @JoinColumn(name = "vol_id", nullable = false)
    private Vol vol;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;



}
